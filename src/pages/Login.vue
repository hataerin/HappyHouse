<template>
  <div class="page-header clear-filter" filter-color="gray">
    <div class="page-header-image" style="background-image: url('https://wallpaperaccess.com/full/85869.jpg')"></div>
    <div class="content">
      <div class="container">
        <div class="ml-auto mr-auto">
          <card type="login" plain>
            <div slot="header" class="logo-container">
              <img v-lazy="'img/now-logo.png'" alt="" />
            </div>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons users_circle-08"
              placeholder="id"
              v-model="id"
            >
            </fg-input>

            <fg-input
              class="no-border input-lg"
              addon-left-icon="now-ui-icons text_caps-small"
              type="password"
              placeholder="pwd"
              v-model="pwd"
              @keyup:enter="login"
            >
            </fg-input>

            <template slot="raw-content">
              <div class="card-footer text-center">
                <a href="#pablo" class="btn btn-primary btn-round btn-lg btn-block" @click="login">로그인</a>
              </div>
              <div class="pull-left">
                <h6>
                  <a href="/signup" class="link footer-link">Create Account</a>
                </h6>
              </div>
              <div class="pull-right"></div>
            </template>
          </card>
        </div>
      </div>
    </div>
    <main-footer></main-footer>
  </div>
</template>
<script>
import { Card, Button, FormGroupInput } from '@/components';
import MainFooter from '@/layout/MainFooter';
export default {
  name: 'login-page',
  bodyClass: 'login-page',
  data() {
    return {
      id: '',
      pwd: '',
    };
  },
  components: {
    Card,
    MainFooter,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
  methods: {
    async login() {
      var _this = this;
      let result = await this.$store.dispatch('login', { id: this.id, pwd: this.pwd });
      if (result) {
        alert('로그인 성공');
        this.$router.replace('/');
      } else {
        alert('로그인 실패');
      }
    },
  },
};
</script>
<style></style>
