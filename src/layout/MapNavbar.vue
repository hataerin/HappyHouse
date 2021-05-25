<template>
  <navbar class="fixed-top" type="primary" :color-on-scroll="colorOnScroll" menu-classes="ml-auto bg-primary fixed-top">
    <template> </template>
    <template slot="navbar-menu">
      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/">
          찰떡하우스
        </router-link>
      </li>
      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/map" style=" font-size: 20px;">
          <i class="now-ui-icons shopping_shop"></i>
          <p>매물찾기</p>
        </router-link>
      </li>

      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/notice" style=" font-size: 20px;">
          <i class="now-ui-icons ui-2_favourite-28"></i>
          <p>공지사항</p>
        </router-link>
      </li>

      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/qna" style=" font-size: 20px;">
          <i class="now-ui-icons location_bookmark"></i>
          <p>자주하는질문</p>
        </router-link>
      </li>

      <li class="nav-item" v-if="user">
        <router-link v-popover:popover1 class="navbar-brand" to="/mypage" style=" font-size: 20px;">
          <i class="now-ui-icons users_single-02"></i>
          <p>마이페이지</p>
        </router-link>
      </li>

      <li class="nav-item" v-if="!user">
        <router-link v-popover:popover1 class="navbar-brand" to="/login" style=" font-size: 20px;">
          <i class="now-ui-icons users_circle-08"></i>
          <p>로그인</p>
        </router-link>
      </li>
      <li class="nav-item" v-if="!user">
        <router-link v-popover:popover1 class="navbar-brand" to="/signup" style=" font-size: 20px;">
          <i class="now-ui-icons users_single-02"></i>
          <p>회원가입</p>
        </router-link>
      </li>

      <!--  <li class="nav-item" v-if="user">
        <router-link v-popover:popover1 class="navbar-brand" to="/" style=" font-size: 20px;" @click="logout">
          <i class="now-ui-icons education_paper"></i>
          <p>로그아웃</p>
        </router-link>
      </li>-->

      <li class="nav-item" v-if="user">
        <div id="logoutBtn" style=" font-size: 20px;" class="navbar-brand" @click="logout">
          <i class="now-ui-icons education_paper"></i>
          <p>로그아웃</p>
        </div>
      </li>
    </template>
  </navbar>
</template>

<script>
import { Navbar } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  data() {
    return {};
  },
  computed: {
    user() {
      return this.$store.getters.user;
    },
  },
  props: {
    transparent: Boolean,
    colorOnScroll: Number,
  },
  components: {
    Navbar,
    [Popover.name]: Popover,
  },
  methods: {
    logout() {
      //logout
      let result = this.$store.dispatch('logout');
      if (result) {
        alert('로그아웃');
        this.$router.push({ path: '/' });
      }
    },
  },
};
</script>

<style scoped>
#logoutBtn {
  cursor: pointer;
}
</style>
