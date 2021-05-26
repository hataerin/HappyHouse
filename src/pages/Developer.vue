<template>
  <div>
    <div class="page-header clear-filter" filter-color="gray">
      <parallax
        class="page-header-image"
        style="background-image:url('https://static.wixstatic.com/media/e09fc4832f914c068d135b9f63cc0679.jpg')"
      ></parallax>
    </div>

    <div class="container">

        <h2 class="title">찰떡하우스 만든사람</h2>
        <div class="team">
          <div class="row">
            <div class="col-md-6">
              <div class="team-player">
                <img src="https://pics.freeicons.io/uploads/icons/png/2985742661548234958-512.png" 
                alt="Thumbnail Image" 
                class="rounded-circle img-fluid img-raised"/>
                <h4 class="title">최승재</h4>
                <p class="category text-primary">Fullstack Developer</p>
                <p class="description">
                  You can write here details about one of your team members. You can give more details about what they
                  do. Feel free to add some <a href="#">links</a> for people to be able to follow them outside the site.
                </p>
              </div>
            </div>
            <div class="col-md-6">
              <div class="team-player">
                <img src="https://pics.freeicons.io/uploads/icons/png/13390292491548234967-512.png" alt="Thumbnail Image" class="rounded-circle img-fluid img-raised" />
                <h4 class="title">하태린</h4>
                <p class="category text-primary">Fullstack Developer</p>
                <p class="description">
                  <a>-대출상품 추천 기능</a><br/>
                  <a>-비디오, 채팅 기능</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>

import { Button } from '@/components';
import axios from 'axios';

const addr = 'http://localhost/rest';

export default {
  name: 'profile',
  bodyClass: 'profile-page',
  computed: {
    user() {
      return this.$store.getters.user;
    },
    loanData() {
      return this.loans;
    },
  },
  components: {
    [Button.name]: Button,
  },
  created() {
    // axios
    //   .get(addr + '/member/info')
    //   .then(() => {})
    //   .catch(() => {
    //     this.$store.dispatch('logout').then(() => {
    //       alert('로그인 후 사용하세요.');
    //       this.$router.replace('/login');
    //       //     this.$router.push({ path: '/' });
    //     });
    //   });
  },
  methods: {
    goChangeInfo() {
      this.$router.replace('/changeInfo');
    },
    deleteMember() {
      let result = this.$store.dispatch('deleteMember', this.user.id);
      //    let result = 1;
      if (result) {
        showAlert();
        alert('회원탈퇴 완료');
        this.$router.replace('/');
      }
    },
    getLoan() {
      console.log('loan');
      axios
        .get(addr + '/loan', {
          params: {
            age: this.age,
            income: this.income,
            houseNum: this.houseNum,
            asset: this.asset,
          },
        })
        .then((res) => {
          this.loans = res.data;
        })
        .catch(() => {});
    },
    goLoanSite(url) {
      window.open(url);
    },
  },
  data() {
    return {
      imgSrc: '...',
      age: '',
      income: '',
      asset: '',
      houseNumText: '보유주택수',
      houseNum: '',
      loans: [],
    };
  },
};
</script>
<style></style>
