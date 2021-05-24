import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
//import createPersistedState from 'vuex-persistedstate';

const addr = 'http://localhost/rest';
Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    accessToken: null,
    nowlat: '',
    nowlng: '',
    housedeal: [],
    user: '',
  },
  getters: {
    housedeals(state) {
      return state.housedeal;
    },
    user(state) {
      return state.user;
    },
    accessToken(state) {
      return state.accessToken;
    },
  },
  actions: {
    deleteMember(context, id) {
      return axios
        .delete(`${addr}/member/` + id)
        .then((response) => {
          //     context.commit('');
          return { Result: 'ok' };
        })
        .catch((error) => {
          console.log(error);
        });
    },
    updateMemberInfo(context, user) {
      return axios.put(`${addr}/member`, user).then((response) => {
        context.commit('UPDATE_MEMBER_INFO', user);
        console.log(response);
        return { Result: 'ok' };
      });
    },
    getSession(context) {
      axios.defaults.headers.common['auth-token'] = sessionStorage.getItem('accessToken');
      console.log('getSession');
      console.dir(sessionStorage.getItem('user'));
      console.log(sessionStorage.getItem('accessToken'));
      return axios
        .get(addr + '/member/info')
        .then((response) => {
          console.log(response);
          context.commit('GET_SESSION');
        })
        .catch(() => {
          //  return this.$store.logout();
        });
    },
    login(context, user) {
      return axios.post(`${addr}/member/login`, user).then(({ data }) => {
        context.commit('LOGIN', data);
        axios.defaults.headers.common['auth-token'] = `${data['auth-token']}`;
        return this.state.user;
      });
    },
    logout(context) {
      context.commit('LOGOUT');
      axios.defaults.headers.common['auth-token'] = undefined;
      return { Result: 'ok' };
    },
    addUser(context, user) {
      return axios.post(`${addr}/member`, user).then((response) => {
        //    console.log(response);
        return { Result: 'ok' };
      });
    },
    getAllHouseDeal({ commit }) {
      return axios
        .get(addr + '/house')
        .then((response) => {
          //          console.log(response.data);
          commit('GET_HOUSE_DEAL', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    searchHouseDeal({ commit }, searchtext) {
      console.log(searchtext);
      let words = searchtext.split(' ');
      console.log(words);
      let searchaddr = addr + '/house/search?';
      for (let i = 0; i < words.length; i++) {
        searchaddr += 'word=' + words[i];
        if (i != words.length - 1) {
          searchaddr += '&';
        }
      }
      console.log(searchaddr);
      return axios
        .get(searchaddr)
        .then((response) => {
          //   console.log(response.data);
          //          console.log(response.data);
          commit('GET_HOUSE_DEAL', response.data);
          return { Result: 'ok' };
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mutations: {
    GET_SESSION(state) {
      state.user = sessionStorage.getItem('user');
      state.accessToken = sessionStorage.getItem('accessToken');
      console.log('-------------------------------');
      console.log(state.user);
      console.log(state.accessToken);
    },
    GET_HOUSE_DEAL(state, data) {
      state.housedeal = data;
      //      console.log('mutations', state.housedeal);
    },
    LOGIN(state, payload) {
      state.accessToken = payload['auth-token'];
      state.user = payload['user'];
      sessionStorage.setItem('user', payload['user']);
      sessionStorage.setItem('accessToken', payload['auth-token']);
    },
    LOGOUT(state) {
      state.accessToken = null;
      state.user = '';
      //      sessionStorage.removeItem('user');
      //      sessionStorage.removeItem('accessToken');
    },
    UPDATE_MEMBER_INFO(state, user) {
      state.user.age = user.age;
      state.user.pwd = user.pwd;
      state.user.eamil = user.email;
      state.user.nickname = user.nickname;
      state.user.mbti = user.mbti;
      state.user.job = user.job;
      state.user.sex = user.sex;
      console.log('UPDATE_MEMBER_INFO:', state.user);
    },
  },
  modeuls: {},
  //  plugins: [createPersistedState()],
});
