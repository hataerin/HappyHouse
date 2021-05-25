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

    <div class="col-md-8 ml-auto mr-auto text-center" style="height:500px;">
      <div>
        <div>{{ qna.qnano }}</div>
        <div>{{ qna.subject }}</div>
        <div>{{ qna.content }}</div>
        <template v-if="user.admin == 0 || qna.userid == user.id">
          <n-button type="primary" @click="goUpdateQna">수정</n-button>
          <n-button type="default" @click="deleteQna">삭제</n-button>
        </template>
      </div>
    </div>
    <!------------------------------->
  </div>
</template>
<script>
import { Button } from '@/components';
import axios from 'axios';
const addr = 'http://localhost/rest/qna';
export default {
  components: {
    [Button.name]: Button,
  },
  data() {
    return {
      qna: '',
      user: '',
    };
  },
  created() {
    axios.get(addr + '/detail/' + this.$route.params.qnano).then((response) => {
      this.qna = response.data;
    });
    this.user = this.$store.getters.user;
  },
  methods: {
    goUpdateQna() {
      this.$router.replace('/qnawrite/update/' + this.qna.qnano);
    },
    deleteQna() {
      return axios
        .delete(addr + '/' + this.qna.qnano)
        .then(() => {
          this.$router.replace('/qna');
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style scoped></style>
