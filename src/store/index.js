import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
//import createPersistedState from 'vuex-persistedstate';

const addr = 'http://localhost/rest';
Vue.use(Vuex);
export default new Vuex.Store({
  state: {
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
  },
  actions: {
    login({ commit }, data) {
      console.log('action:', data);
      return axios
        .post(addr + '/member/login', data)
        .then((response) => {
          commit('LOGIN', response.data);
          return { Result: 'ok' };
        })
        .catch((error) => {
          console.log(error);
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
    GET_HOUSE_DEAL(state, data) {
      state.housedeal = data;
      //      console.log('mutations', state.housedeal);
    },
    LOGIN(state, data) {
      console.log('login', data);
      state.user = data;
    },
  },
  modeuls: {},
  //  plugins: [createPersistedState()],
});
