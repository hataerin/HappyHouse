<template>
  <div>
    <div class="page-header clear-filter" filter-color="gray">
      <parallax
        class="page-header-image"
        style="background-image:url('https://static.wixstatic.com/media/e09fc4832f914c068d135b9f63cc0679.jpg')"
      >
      </parallax>

      <loader v-if="showloader" />
    </div>

    
  </div>
</template>

<script>
import { CometChat } from "@cometchat-pro/chat";
import { CometChatAvatar } from "../cometchat-pro-vue-ui-kit";

import { COMETCHAT_CONSTANTS } from "../CONSTS";
import Loader from "../Loader/Loader";

import * as style from "./style";

export default {
  name: "AppHome",
  components: {
    Loader,
  },
  data() {
    return {
      users: [
        {
          name: "superhero1",
          image:
            "https://data-us.cometchat.io/assets/images/avatars/ironman.png",
        },
        {
          name: "superhero2",
          image:
            "https://data-us.cometchat.io/assets/images/avatars/captainamerica.png",
        },
        {
          name: "superhero3",
          image:
            "https://data-us.cometchat.io/assets/images/avatars/spiderman.png",
        },
        {
          name: "superhero4",
          image:
            "https://data-us.cometchat.io/assets/images/avatars/wolverine.png",
        },
        {
          name: "superhero5",
          image:
            "https://data-us.cometchat.io/assets/images/avatars/cyclops.png",
        },
      ],
      showloader: false,
      uid: "superhero1",
    };
  },
  computed: {
    styles() {
      return {
        wrapper: style.wrapperStyle(),
        title: style.titleStyle(),
        subtitle: style.subtitleStyle(),
        userWrapper: style.userWrapperStyle(),
        userSelector: style.userSelectorStyle(),
        avatarWrapper: style.avatarWrapperStyle(),
        loginText: style.loginTextStyle(),
        input: style.inputStyle(),
        loginButton: style.loginButtonStyle(),
      };
    },
  },
  created() {
    this.showloader = true;
    CometChat.login(this.uid, COMETCHAT_CONSTANTS.AUTH_KEY)
      .then((user) => {
        console.log("User logged in : ", user);
        location.href = "/embedded-app";
      })
      .catch((error) => {
        console.log("Error in [login]", error);
        alert((error || {}).message || "Error in login");
      })
      .finally(() => {
        this.showloader = false;
      });
  },
};
</script>