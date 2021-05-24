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
        <div>{{ notice.noticeno }}</div>
        <div>{{ notice.subject }}</div>
        <div>{{ notice.content }}</div>
      </div>
    </div>
    <!------------------------------->
  </div>
</template>
<script>
import axios from 'axios';
const addr = 'http://localhost/rest/notice';
export default {
  data() {
    return {
      notice: '',
    };
  },
  mounted() {
    axios.get(addr + '/detail/' + this.$route.params.noticeno).then((response) => {
      this.notice = response.data;
    });
  },
};
</script>
<style scoped></style>
