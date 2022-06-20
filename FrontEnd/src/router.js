import Vue from 'vue';
import Router from 'vue-router';
import Index from './pages/Index.vue';
import Landing from './pages/Landing.vue';
import signup from './pages/signup.vue';
import Login from './pages/Login.vue';
import Profile from './pages/Profile.vue';
import MyPage from './pages/MyPage.vue';
import Likes from './pages/Likes.vue';
import MainNavbar from './layout/MainNavbar.vue';
import MainFooter from './layout/MainFooter.vue';
import Map from './pages/Map.vue';
import MapNavbar from './layout/MapNavbar.vue';
//import { ElNotificationComponent } from 'element-ui/types/notification';
import Notice from './pages/Notice.vue';
import ChangeInfo from './pages/ChangeInfo.vue';

import Qna from './pages/QnA.vue';
import NoticeDetail from './pages/NoticeDetail.vue';
import QnaDetail from './pages/QnaDetail.vue';
import NoticeWrite from './pages/NoticeWrite.vue';
import Video from './pages/Video.vue';
import { CometChatUI } from './cometchat-pro-vue-ui-kit/';
import QnaWrite from './pages/QnaWrite.vue';
Vue.use(Router);

export default new Router({
  mode: 'history',
  linkExactActiveClass: 'active',
  routes: [
    {
      path: '/qnawrite/:mode/:no',
      name: 'qnawrite',
      components: { default: QnaWrite, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/noticewrite/:mode/:no',
      name: 'noticewrite',
      components: { default: NoticeWrite, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/noticedetail/:noticeno',
      name: 'noticetail',
      components: { default: NoticeDetail, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/qna',
      name: 'qna',
      components: { default: Qna, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/signup',
      name: 'signup',
      components: { default: signup, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/changeInfo',
      name: 'changeInfo',
      components: { default: ChangeInfo, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/qwer',
      name: 'index',
      components: { default: Index, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/notice',
      name: 'Notice',
      components: { default: Notice, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/qnaDetail/:qnano',
      name: 'QnaDetail',
      components: { default: QnaDetail, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/',
      name: 'landing',
      components: { default: Landing, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/login',
      name: 'login',
      components: { default: Login, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 },
      },
    },
    {
      path: '/map',
      name: 'map',
      components: {
        default: Map,
        header: MainNavbar,
      },
      props: {
        header: { colorOnScroll: 400 },
      },
    },
    {
      path: '/profile',
      name: 'profile',
      components: { default: Profile, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/likes',
      name: 'likes',
      components: { default: Likes, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/mypage',
      name: 'mypage',
      components: { default: MyPage, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/video',
      name: 'video',
      components: { default: Video, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
    {
      path: '/embedded-app',
      name: '/embedded-app',
      components: { default: CometChatUI, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' },
      },
    },
  ],
  scrollBehavior: (to) => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  },
});
