<template>
  <navbar position="fixed" type="primary" :color-on-scroll="colorOnScroll" menu-classes="ml-auto bg-primary">
    <template>
      <router-link v-popover:popover1 class="navbar-brand" to="/">
        찰떡하우스
      </router-link>
    </template>
    <template slot="navbar-menu">
      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/map" style=" font-size: 20px;">
          <i class="now-ui-icons shopping_shop"></i>
          <p>매물찾기</p>
        </router-link>
      </li>

      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/likes" style=" font-size: 20px;">
          <i class="now-ui-icons ui-2_favourite-28"></i>
          <p>관심목록</p>
        </router-link>
      </li>

      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/" style=" font-size: 20px;">
          <i class="now-ui-icons location_bookmark"></i>
          <p>자주하는질문</p>
        </router-link>
      </li>

      <li class="nav-item">
        <router-link v-popover:popover1 class="navbar-brand" to="/mypage" style=" font-size: 20px;">
          <i class="now-ui-icons users_single-02"></i>
          <p>마이페이지</p>
        </router-link>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="https://www.creative-tim.com/product/vue-now-ui-kit" target="_blank">
          <i class="now-ui-icons arrows-1_cloud-download-93"></i>
          <p>Download</p>
        </a>
      </li>

      <drop-down tag="li" title="Examples" icon="now-ui-icons design_image" class="nav-item">
        <nav-link to="/landing"> <i class="now-ui-icons education_paper"></i> Landing </nav-link>
        <nav-link to="/login"> <i class="now-ui-icons users_circle-08"></i> Login </nav-link>
        <nav-link to="/profile"> <i class="now-ui-icons users_single-02"></i> Profile </nav-link>
      </drop-down>
    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  props: {
    transparent: Boolean,
    colorOnScroll: Number,
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover,
  },
};
</script>

<style scoped></style>
