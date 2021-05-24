<template>
  <div>
    <div class="page-header clear-filter" filter-color="gray">
      <parallax
        class="page-header-image"
        style="background-image:url('https://static.wixstatic.com/media/e09fc4832f914c068d135b9f63cc0679.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="photo-container">
          <img src="img/ryan.jpg" alt="" />
        </div>
        <h3 class="title">{{ user.nickname }}</h3>

        <p class="category">{{ user.email }}</p>
        <p class="category">{{ user.id }}</p>
        <p class="category">{{ user.age }}</p>
        <p class="category">{{ user.mbti }}</p>
        <p class="category">{{ user.job }}</p>
        <div class="content">
          <div class="social-description">
            <h2>26</h2>
            <p>Comments</p>
          </div>
          <div class="social-description">
            <h2>26</h2>
            <p>Comments</p>
          </div>
          <div class="social-description">
            <h2>48</h2>
            <p>Bookmarks</p>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="button-container">
          <a href="#button" class="btn btn-primary btn-round btn-lg" @click="goChangeInfo">회원수정</a>
          <a href="#button" class="btn btn-default btn-round btn-lg" @click="deleteMember">회원탈퇴</a>
          <a
            href="#button"
            class="btn btn-default btn-round btn-lg btn-icon"
            rel="tooltip"
            title="Follow me on Twitter"
          >
            <i class="fab fa-twitter"></i>
          </a>
          <a
            href="#button"
            class="btn btn-default btn-round btn-lg btn-icon"
            rel="tooltip"
            title="Follow me on Instagram"
          >
            <i class="fab fa-instagram"></i>
          </a>
        </div>
        <h3 class="title">설문조사</h3>
        <h5 class="description">
          당신의 선호도, 라이프스타일, 직업 그리고 예산에 관한 몇가지 질문에 답해주세요
        </h5>

        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">성격</h4>
          </div>

          <div class="col-md-10 ml-auto mr-auto">
            <div class="row collections">
              <div class="col-md-6">
                <img src="img/bg3.jpg" alt="" class="img-raised" style="" />
                <img src="img/bg8.jpg" alt="" class="img-raised" />
              </div>
              <div class="col-md-6">
                <img src="img/bg7.jpg" alt="" class="img-raised" />
                <img src="img/bg6.jpg" class="img-raised" />
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">My Portfolio</h4>
          </div>

          <tabs
            pills
            class="nav-align-center"
            tab-content-classes="gallery"
            tab-nav-classes="nav-pills-just-icons"
            type="primary"
          >
            <tab-pane title="Profile">
              <i slot="label" class="now-ui-icons design_image"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg6.jpg" class="img-raised" />
                    <img src="img/bg11.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Home">
              <i slot="label" class="now-ui-icons location_world"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg1.jpg" alt="" class="img-raised" />
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Messages">
              <i slot="label" class="now-ui-icons sport_user-run"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg6.jpg" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>
          </tabs>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Tabs, TabPane } from '@/components';
import axios from 'axios';

const addr = 'http://localhost/rest';

export default {
  name: 'profile',
  bodyClass: 'profile-page',
  computed: {
    user() {
      console.log(this.$store.getters.user);
      return this.$store.getters.user;
    },
  },
  components: {
    Tabs,
    TabPane,
  },
  created() {
    axios
      .get(addr + '/member/info')
      .then(() => {})
      .catch(() => {
        this.$store.dispatch('logout').then(() => {
          alert('로그인 후 사용하세요.');
          this.$router.replace('/login');
          //     this.$router.push({ path: '/' });
        });
      });
  },
  methods: {
    goChangeInfo() {
      this.$router.replace('/changeInfo');
    },
    deleteMember() {
      this.$router.replace('/');
    },
  },
};
</script>
<style></style>
