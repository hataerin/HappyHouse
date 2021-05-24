<template>
  <div>
    <div class="page-header page-header-small">
      <parallax class="page-header-image" style="background-image: url('https://wallpaperaccess.com/full/85869.jpg')">
      </parallax>
      <div class="content-center">
        <div class="container">
          <h2 class="title">당신에게 꼭 맞는 찰떡같은 집</h2>
          <h1 class="title">찰떡하우스</h1>
          <br /><br /><br />
        </div>
      </div>
    </div>

    <!------------------------------------------------------->

    <div class="col-md-8 ml-auto mr-auto text-center">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="input-group-0" label="아이디:" label-for="input-0">
          <b-form-input id="input-0" v-model="form.id" placeholder="Enter ID" disabled></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="나이:" label-for="input-1">
          <b-form-input type="number" id="input-1" v-model="form.age" placeholder="Enter AGE" required></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="비밀번호:" label-for="input-2">
          <b-form-input
            type="password"
            id="input-2"
            v-model="form.pwd"
            placeholder="Enter PASSWORD"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-3" label="비밀번호 확인:" label-for="input-3">
          <b-form-input
            type="password"
            id="input-3"
            v-model="repwd"
            :state="pwdValidation"
            placeholder="Enter REPASSWORD"
            required
          ></b-form-input>
          <b-form-invalid-feedback :state="pwdValidation">
            비밀번호와 다르거나 빈칸입니다.
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="pwdValidation">
            확인되었습니다.
          </b-form-valid-feedback>
        </b-form-group>
        <b-form-group id="input-group-4" label="이메일:" label-for="input-4">
          <b-form-input
            id="input-4"
            v-model="form.email"
            type="email"
            placeholder="Enter email"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="닉네임:" label-for="input-5">
          <b-form-input id="input-5" v-model="form.nickname" placeholder="Enter nickname" required></b-form-input>
        </b-form-group>
        <b-form-group id="input-group-6" label="mbti:" label-for="input-6">
          <b-form-input id="input-6" v-model="form.mbti" placeholder="Enter MBTI"></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="직업:" label-for="input-7">
          <b-form-select id="input-7" v-model="form.job" :options="jobs"></b-form-select>
        </b-form-group>

        <b-form-radio-group label="성별" v-slot="{ ariaDescribedby }">
          <b-form-radio v-model="form.sex" :aria-describedby="ariaDescribedby" name="some-radios" value="1" class="mt-3"
            >남자</b-form-radio
          >
          <b-form-radio v-model="form.sex" :aria-describedby="ariaDescribedby" name="some-radios" value="2" class="mt-3"
            >여자</b-form-radio
          >
        </b-form-radio-group>
        <b-button type="submit" variant="primary">수정</b-button>
        <b-button type="reset" variant="danger">취소</b-button>
      </b-form>
    </div>
    <!------------------------------->
    <div class="section section-team text-center">
      <div class="container">
        <h2 class="title">Here is our team</h2>
        <div class="team">
          <div class="row">
            <div class="col-md-6">
              <div class="team-player">
                <img src="img/avatar.jpg" alt="Thumbnail Image" class="rounded-circle img-fluid img-raised" />
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
                <img src="img/ryan.jpg" alt="Thumbnail Image" class="rounded-circle img-fluid img-raised" />
                <h4 class="title">하태린</h4>
                <p class="category text-primary">Fullstack Developer</p>
                <p class="description">
                  You can write here details about one of your team members. You can give more details about what they
                  do. Feel free to add some <a href="#">links</a> for people to be able to follow them outside the site.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Button, FormGroupInput } from '@/components';
// import axios from 'axios';
// const addr = 'http://localhost/rest/notice';
export default {
  name: 'landing',
  bodyClass: 'landing-page',
  components: {
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
  created() {
    this.getUserInfo();
  },
  data() {
    return {
      form: {
        id: '',
        age: '',
        pwd: '',
        nickname: '',
        sex: '',
        mbti: '',
        job: null,
        email: '',
      },
      repwd: '',
      jobs: [{ text: 'Select One', value: null }, '취준생', '대학생', '직장인', '주부'],
    };
  },
  computed: {
    pwdValidation() {
      return this.form.pwd == this.repwd && this.repwd.length > 0;
    },
  },
  methods: {
    getUserInfo() {
      let user = this.$store.getters.user;
      console.log('user:', user);
      this.form.id = user.id;
      this.form.age = user.age;
      this.form.pwd = user.pwd;
      this.form.nickname = user.nickname;
      this.form.sex = user.sex;
      this.form.mbti = user.mbti;
      this.form.job = user.job;
      this.form.email = user.email;
      console.log('mounted:', this.form);
    },
    onSubmit(event) {
      event.preventDefault();
      let _this = this;
      console.log(this.form);
      if (this.pwdValidation) {
        let result = this.$store.dispatch('updateMemberInfo', this.form); //
        /*
        
        
        
        
        
        */
        console.log(this.form);
        if (result) {
          alert(result);
          this.$router.replace('/mypage');
        }
      } else {
        alert('조건을 확인하세요');
      }
    },
    onReset(event) {
      event.preventDefault();
      this.$router.replace('/mypage');
    },
  },
};
</script>
<style></style>
