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
        .get(addr + '/house')
        .then((response) => {
          console.log(response);
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
    },
  },
  modeuls: {},
  plugins: [createPersistedState()],
});
