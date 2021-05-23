import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import createPersistedState from 'vuex-persistedstate';

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
  },
  actions: {
    getAllHouseDeal({ commit }) {
      axios
        .get(addr + '/house/search/서울')
        .then((response) => {
          console.log(response.data);
          commit('GET_ALL_HOUSE_DEAL', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mutations: {
    GET_ALL_HOUSE_DEAL(state, data) {
      state.housedeal = data;
      console.log('mutations', state.housedeal);
    },
  },
  modeuls: {},
  plugins: [createPersistedState()],
});
