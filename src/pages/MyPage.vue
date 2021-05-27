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
        <div class="content"></div>
      </div>
    </div>

    <div class="section">
      <div class="container">
        <div class="button-container">
          <a href="#button" class="btn btn-primary btn-round btn-lg" @click="goChangeInfo">회원수정</a>
          <a href="#button" class="btn btn-default btn-round btn-lg" @click="deleteMember">회원탈퇴</a>
        </div>
        <div></div>

        <div style="text-align: center;">
          <img
            src="https://image.freepik.com/free-vector/mortgage-loan-against-background-calculator-house_178888-288.jpg"
            alt=""
            style=""
          />
        </div>

        <h2 class="title">주택을 구입할 자금 대출이 필요하신가요?</h2>
        <h5 class="description">
          나이, 소득 등 당신에 관한 몇가지 질문에 답하고 맞춤 주거복지 서비스를 찾아보세요
        </h5>
        <div class="ml-auto mr-auto text-center">
          <div class="col">
            <fg-input label="나이(만)" placeholder="나이를 입력해주세요" v-model="age" type="search"> </fg-input>
            <fg-input
              label="연소득(만원)"
              placeholder="기혼의 경우 부부합산 연소득을 입력해주세요"
              v-model="income"
              type="search"
            >
            </fg-input>
            <fg-input label="순자산가액(억)" placeholder="예) 5억4천만원 -> 5.4" v-model="asset" type="search">
            </fg-input>
            <div>
              <div>
                <drop-down>
                  <n-button
                    slot="title"
                    type="primary"
                    simple
                    class="dropdown-toggle"
                    data-toggle="dropdown"
                    block
                    round
                  >
                    {{ houseNumText }}
                  </n-button>
                  <h6 class="dropdown-header">Dropdown header</h6>
                  <a class="dropdown-item" v-on:click="(houseNumText = '무주택'), (houseNum = 0)">무주택</a>
                  <a class="dropdown-item" v-on:click="(houseNumText = '1주택'), (houseNum = 1)">1주택</a>
                  <a class="dropdown-item" v-on:click="(houseNumText = '다주택'), (houseNum = 2)">다주택</a>
                </drop-down>
                <n-button type="primary" size="lg" v-on:click="getLoan">찰떡 대출 찾아보기</n-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <template v-for="loan of loanData">
      <div class="ml-auto mr-auto text-center" :key="loan.name">
        <card v-bind:key="loan.id" style="width: 30rem;">
          <img
            slot="image"
            class="card-img-top"
            src="https://www.bestcommunitybanks.com/uploads/news-pictures/3-new-york-blog-post-image-20200319104136.jpg"
            alt="Card image cap"
          />
          <div>
            <h4 class="card-title" style="font-weight: bold;">{{ loan.name }}</h4>
            <p class="card-text">{{ loan.description }}</p>
            <div style="text-align: left;">
              <strong>대출대상</strong>
              {{ loan.object_description }}
              <br /><strong>대출금리</strong> {{ loan.rate }} <br /><strong>대출한도</strong> {{ loan.limit }}
              <br /><strong>대출기간</strong> {{ loan.term }}
            </div>
            <br /><n-button type="primary" @click="goLoanSite(loan.url)">자세히 보기</n-button>
          </div>
        </card>
      </div>
    </template>
  </div>
</template>

<script>
import { Card } from '@/components';
import { FormGroupInput as FgInput } from '@/components';
import { DropDown } from '@/components';
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
    Card,
    FgInput,
    DropDown,
    [Button.name]: Button,
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
<style>
  .form-control {
    font-size: 30px;
  }
  label {
    font-size: 20px;
  }
</style>
