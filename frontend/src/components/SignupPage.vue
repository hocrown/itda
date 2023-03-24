<template>
  <div>
    <Step1Page
      v-if="currentStep === 1"
      @update:valid="updateCodeValidity"
      @update:code="updateCode"
      @next="nextStep"
    />
    <Step2Page
      v-if="currentStep === 2"
      @update:valid="updateIdValidity"
      @update:user-pw-validity="updateUserPwValidity"
      @next="nextStep"
    />
    <Step3Page
      v-if="currentStep === 3"
      @save="saveData"/>

  </div>
</template>
<script>
import Step1Page from './Step1Page.vue';
import Step2Page from './Step2Page.vue';
import Step3Page from './Step3Page.vue';
import VueRouter from 'vue-router';

export default {
  name: 'SignupPage',
  components: {
    Step1Page,
    Step2Page,
    Step3Page
  },
  data() {
    return {
      currentStep: 1,
      isCodeValid: false,
      code: '',
      isIdValid: false,
      isUserPwValid: false
    };
  },
  methods: {
    updateCodeValidity(isValid) {
      this.isCodeValid = isValid;
    },
    updateCode(code) {
      this.code = code;
    },
    updateIdValidity(isValid) {
      this.isIdValid = isValid;
    },
    updateUserPwValidity(isValid) {
      this.isUserPwValid = isValid;
    },
    nextStep() {
      this.currentStep++;
    },
    saveData() {
      const familyData = {
        code: this.$store.state.signup.familyCode
      };
      const userData = {
        userId: this.$store.state.signup.userId,
        userPw: this.$store.state.signup.userPw,
        userName: this.$store.state.signup.userName,
        userAge: this.$store.state.signup.userAge,
        userSex: this.$store.state.signup.userSex,
        userAddress: this.$store.state.signup.userAddress,
        userPhone: this.$store.state.signup.userPhone,
        email: this.$store.state.signup.email,
        approve: this.$store.state.signup.approve
      };
      this.$store.dispatch('signup', { familyData, userData }).then(response => {
        if (response.success) {
          this.errorMsg = '';
          this.$router.push({ path: '/signup/complete' });
        } else {
          this.errorMsg = response.errorMsg;
        }
      }).catch(error => {
        console.log(error);
      });

      // 이동할 경로
      const path = '/main.jsp';

      // 라우터 객체 생성
      const router = new VueRouter({
        mode: history,
        base: process.env.BASE_URL,
      });

      // 경로 이동
      router.push({ path });
    },
  }
};
</script>