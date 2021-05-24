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
            <fg-input label="나이(만)" placeholder="나이를 입력해주세요" value="" type="search"> </fg-input>
            <fg-input
              label="연소득(만원)"
              placeholder="기혼의 경우 부부합산 연소득을 입력해주세요"
              value=""
              type="search"
            >
            </fg-input>
            <fg-input label="순자산가액(억)" placeholder="예) 5억4천만원 -> 5.4" value="" type="search"> </fg-input>
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
                    보유주택수
                  </n-button>
                  <h6 class="dropdown-header">Dropdown header</h6>
                  <a class="dropdown-item" href="#">무주택</a>
                  <a class="dropdown-item" href="#">1주택</a>
                  <a class="dropdown-item" href="#">다주택</a>
                </drop-down>
                <n-button type="primary" size="lg">찰떡 대출 찾아보기</n-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="ml-auto mr-auto text-center">
      <card style="width: 30rem;">
        <img
          slot="image"
          class="card-img-top"
          src="https://www.bestcommunitybanks.com/uploads/news-pictures/3-new-york-blog-post-image-20200319104136.jpg"
          alt="Card image cap"
        />
        <div>
          <h4 class="card-title">내집마련 디딤돌 대출</h4>
          <p class="card-text">정부지원 3대 서민 구입자금을 하나로 통합한 저금리 구입자금대출입니다.</p>
          <strong>대출대상</strong>
          주택매매계약을 체결한 자, 대출신청일 현재 무주택 세대주, 부부합산 연소득 6천만원 이하, 순자산가액 3.94억원
          이하인 자
          <br /><strong>대출금리</strong> 연 1.85~2.40% <br /><strong>대출한도</strong> 최고 2억원 이내 <br /><strong
            >대출기간</strong
          >
          10년, 15년, 20년, 30년 <br /><n-button type="primary">자세히 보기</n-button>
        </div>
      </card>
    </div>
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
        alert('회원탈퇴 완료');
        this.$router.replace('/');
      }
    },
  },
  data() {
    return {
      imgSrc: '...',
    };
  },
};
</script>
<style></style>
