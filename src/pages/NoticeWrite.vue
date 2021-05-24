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
        <b-form-group id="input-group-1" label="제목:" label-for="input-1">
          <b-form-input type="number" id="input-1" v-model="form.age" placeholder="Enter TITLE" required></b-form-input>
        </b-form-group>
        <div>
          <b-form-textarea v-model="value" debounce="500" rows="10" max-rows="15"></b-form-textarea>
          <pre class="mt-2 mb-0">{{ value }}</pre>
        </div>

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
        alert(JSON.stringify(this.form));
        let result = this.$store.dispatch('addUser', this.form);
        if (result) {
          alert(result);
          this.$router.replace('/login');
        }
      } else {
        alert('조건을 확인하세요');
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values

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
<style scoped></style>
