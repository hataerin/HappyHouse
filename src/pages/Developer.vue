<template>
  <div class="section section-team text-center">
      <div class="container">

        <h2 class="title">찰떡하우스 사장님들</h2>
        <div class="team">
          <div class="row">
            <div class="col-md-6">
              <div class="team-player">
                <img src="https://pics.freeicons.io/uploads/icons/png/2985742661548234958-512.png" 
                alt="Thumbnail Image" 
                class="rounded-circle img-fluid img-raised" />
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

    


</template>
<script>
import { Button, FormGroupInput } from '@/components';
import {Card} from '@/components'
export default {
  name: 'landing',
  bodyClass: 'landing-page',
  components: {
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
    [Card.name]: Card,
  },
  data() {
    return {
      form: {
        firstName: '',
        email: '',
        message: '',
      },
    };
  },
};
</script>
<style></style>
