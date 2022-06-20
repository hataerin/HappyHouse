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

    <div class="col-md-8 ml-auto mr-auto text-center" style="height:500px;margin:30px;">
      <b-form>
        <b-form-group id="input-group-1" label="제목:" label-for="input-1">
          <b-form-input
            type="text"
            id="input-1"
            v-model="form.subject"
            placeholder="Enter TITLE"
            required
          ></b-form-input>
        </b-form-group>
        <div>
          <b-form-textarea v-model="form.content" debounce="500" rows="10" max-rows="15"></b-form-textarea>
          <pre class="mt-2 mb-0"></pre>
        </div>

        <b-button type="submit" variant="primary" v-if="mode == 'update'" @click="updateNotice">수정</b-button>
        <b-button type="submit" variant="primary" v-if="mode == 'write'" @click="writeNotice">작성</b-button>
        <b-button type="reset" variant="danger" @click="goList">취소</b-button>
      </b-form>
    </div>

    <!------------------------------->
  </div>
</template>
<script>
import { Button, FormGroupInput } from '@/components';
import axios from 'axios';
const addr = 'http://localhost/rest/notice';
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
        subject: '',
        content: '',
        userid: '',
      },
      mode: '',
      no: '',
    };
  },
  created() {
    this.getMode();
    this.getUserId();
  },
  methods: {
    getMode() {
      this.no = this.$route.params.no;
      this.mode = this.$route.params.mode;
      if (this.no != 0) {
        axios
          .get(addr + '/detail/' + this.no)
          .then((response) => {
            this.form.content = response.data.content;
            this.form.subject = response.data.subject;
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    getUserId() {
      this.form.userid = this.$store.getters.user.id;
    },
    updateNotice(event) {
      event.preventDefault();
      this.form.noticeno = this.no;
      return axios
        .put(addr, this.form)
        .then((response) => {
          console.log(response);
          this.$router.replace('/notice');
        })
        .catch((error) => {
          console.log(error);
        });
    },
    writeNotice(event) {
      event.preventDefault();
      return axios
        .post(addr, this.form)
        .then((response) => {
          this.$router.replace('/notice');
        })
        .catch((error) => {
          console.log(error);
        });
    },
    goList() {
      this.$router.replace('/notice');
    },
  },
};
</script>
<style scoped></style>
