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

    <div class="ml-auto mr-auto text-center">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="input-group-0" label="아이디:" label-for="input-0">
          <b-form-input
            id="input-0"
            :state="idValidation"
            v-model="form.id"
            placeholder="Enter ID"
            required
          ></b-form-input>
          <b-form-invalid-feedback :state="idValidation">
            사용할 수 없는 아이디 입니다.
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="idValidation">
            사용할 수 있는 아이디 입니다.
          </b-form-valid-feedback>
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
        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
      </b-form>
    </div>
    <!------------------------------->
  </div>
</template>
<script>
import { Button, FormGroupInput } from '@/components';
import axios from 'axios';
const addr = 'http://localhost/rest/member';
export default {
  name: 'landing',
  bodyClass: 'landing-page',
  components: {
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
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
        admin: '1',
        email: '',
      },
      repwd: '',
      jobs: [{ text: 'Select One', value: null }, '취준생', '대학생', '직장인', '주부'],
      ids: [],
    };
  },
  created() {
    this.getId();
  },
  computed: {
    idValidation() {
      //   console.log(this.form.id.length);
      //   return this.form.id.length > 4 && this.form.id.length < 13;
      //  let index = this.ids.indexOf(this.form.id);
      let index = this.ids.indexOf(this.form.id);
      return this.form.id.length > 0 && this.form.id.length < 20 && -1 == index;
    },
    pwdValidation() {
      return this.form.pwd == this.repwd && this.repwd.length > 0;
    },
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      if (this.idValidation && this.pwdValidation) {
        let result = this.$store.dispatch('addUser', this.form);
        if (result) {
          alert('회원가입 성공');
          this.$router.replace('/login');
        }
      } else {
        alert('조건을 확인하세요');
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.id = '';
      this.form.age = '';
      this.form.pw = '';
      this.form.repwd = '';
      this.form.nickname = '';
      this.form.sex = '';
      this.form.mbti = '';
      this.form.job = '';
      this.form.email = '';
      // Trick to reset/clear native browser form validation state
    },
    getId() {
      return axios
        .get(addr)
        .then((response) => {
          this.ids = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style></style>
