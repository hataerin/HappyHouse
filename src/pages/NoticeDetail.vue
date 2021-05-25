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
        <div>글 번호 : {{ notice.noticeno }}</div>
        <div>글 제목 : {{ notice.subject }}</div>
        <div>글 내용 : {{ notice.content }}</div>
        <template v-if="user.admin == 0 || notice.userid == user.id">
          <n-button type="primary" @click="goUpdateNotice">수정</n-button>
          <n-button type="default" @click="deleteNotice">삭제</n-button>
        </template>
      </div>
    </div>
    <!------------------------------->
  </div>
</template>
<script>
import { Button } from '@/components';
import axios from 'axios';
const addr = 'http://localhost/rest/notice';

export default {
  components: {
    [Button.name]: Button,
  },
  data() {
    return {
      notice: '',
      user: '',
    };
  },
  created() {
    axios.get(addr + '/detail/' + this.$route.params.noticeno).then((response) => {
      this.notice = response.data;
    });
    this.user = this.$store.getters.user;
  },
  methods: {
    goUpdateNotice() {
      this.$router.replace('/noticewrite/update/' + this.notice.noticeno);
    },
    deleteNotice() {
      return axios
        .delete(addr + '/' + this.notice.noticeno)
        .then((response) => {
          console.log(response);
          this.$router.replace('/notice');
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style scoped></style>
