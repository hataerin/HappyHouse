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
    <div style="margin-top:40px;">
      <div class="col-md-8 ml-auto mr-auto text-center">
        <h2>공지 사항</h2>
        <b-table striped hover :items="items" @row-clicked="goDetailNotice"></b-table>
      </div>
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
// import { Button, FormGroupInput } from '@/components';
import axios from 'axios';
const addr = 'http://localhost/rest/notice';
export default {
  data() {
    return {
      items: [],
    };
  },
  created() {
    let _this = this;
    return axios
      .get(addr)
      .then((response) => {
        _this.items = [];
        for (let i = 0; i < response.data.length; i++) {
          console.log('asd');
          _this.items.push({
            no: response.data[i].noticeno,
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
      this.$router.push({ path: '/noticeDetail/' + item.no });
    },
  },
};
</script>
<style scoped>
img {
  max-width: 100px;
}
</style>
