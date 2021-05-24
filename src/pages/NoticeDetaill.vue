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
import axios from 'axios';
const addr = 'http://localhost/rest/member';
export default {};
</script>
<style></style>
