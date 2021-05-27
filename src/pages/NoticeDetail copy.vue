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

    <div class="col-md-8 ml-auto mr-auto text-center" style="height:550px;">
      <div>
        <b-table-simple caption-top responsive>
          <b-tbody>
            <b-tr>
              <b-th colspan="2">글 번호</b-th>
              <b-td colspan="3">{{ notice.noticeno }}</b-td>
            </b-tr>
            <b-tr>
              <b-th colspan="2">글 제목</b-th>
              <b-td colspan="3">{{ notice.subject }}</b-td>
            </b-tr>
            <b-tr>
              <b-th colspan="2">글 작성자</b-th>
              <b-td colspan="3">{{ notice.userid }}</b-td>
            </b-tr>
            <b-tr>
              <b-th colspan="2">글 작성일</b-th>
              <b-td colspan="3">{{ notice.regtime }}</b-td>
            </b-tr>
            <b-tr>
              <b-th colspan="2">글 내용</b-th>
              <b-td colspan="3">{{ notice.content }}</b-td>
            </b-tr>
          </b-tbody>
        </b-table-simple>
        <div>글 번호 : {{ notice.noticeno }}</div>
        <div>글 제몰 : {{ notice.subject }}</div>
        <div>글 작성자 : {{ notice.userid }}</div>
        <div>글 작성일 : {{ notice.regtime }}</div>
        <div>글 내용 : {{ notice.content }}</div>
        <template v-if="user.admin == 0 || notice.userid == user.id">
          <n-button type="primary" @click="goUpdateNotice">수정</n-button>
          <n-button type="default" @click="deleteNotice">삭제</n-button>
        </template>
        <div>
          <n-button type="primary" @click="goList">목록</n-button>
        </div>
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
    goList() {
      this.$router.replace('/notice');
    },
  },
};
</script>
<style scoped></style>
