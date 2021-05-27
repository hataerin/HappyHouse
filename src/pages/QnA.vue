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
    <div style="margin-top:40px;margin-bottom:40px;margin-left:150px;margin-right:150px" >
      <div class="ml-auto mr-auto text-center">
        <h2>QnA</h2>
        <n-button type="primary" v-if="admin == 0 || admin == 1" @click="goWrite">글쓰기</n-button>
        <b-table striped hover :items="items" @row-clicked="goDetailNotice" style="font-size: 2em;"></b-table>
      </div>
    </div>
    <!------------------------------->
  </div>
</template>
<script>
// import { Button, FormGroupInput } from '@/components';
import axios from 'axios';
import { Button } from '@/components';
const addr = 'http://localhost/rest/qna';
export default {
  components: {
    [Button.name]: Button,
  },
  data() {
    return {
      items: [],
      admin: '',
    };
  },
  created() {
    this.admin = this.$store.getters.user.admin;
    let _this = this;
    return axios
      .get(addr)
      .then((response) => {
        _this.items = [];
        for (let i = 0; i < response.data.length; i++) {
          console.log('asd');
          _this.items.push({
            no: response.data[i].qnano,
            title: response.data[i].subject,
            author: response.data[i].userid,
          });
        }
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    goDetailNotice(item) {
      this.$router.push({ path: '/qnaDetail/' + item.no });
    },
    goWrite() {
      this.$router.replace('/qnaWrite/write/0');
    },
  },
};
</script>
<style scoped>
img {
  max-width: 100px;
}
</style>
