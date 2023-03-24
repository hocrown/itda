<template>
  <div>
    <h2>Step 2</h2>
    <div>
      <label for="userIdInput">아이디</label>
      <input type="text" id="userIdInput" v-model="userId" />
      <div v-if="!isIdValid" class="error">* 영문 소문자, 숫자만 사용 가능하며, 5자 이상 12자 이하로 작성해주세요.</div>
    </div>
    <div>
      <label for="userPwInput">비밀번호</label>
      <input type="password" id="userPwInput" v-model="userPw" />
      <div v-if="!isUserPwValid" class="error">* 영문 대/소문자, 숫자, 특수문자를 각각 1개 이상 포함해 8자 이상 16자 이하로 작성해주세요.</div>
    </div>
    <button type="button" @click="goToNextStep" :disabled="!isIdValid || !isUserPwValid">다음</button>
  </div>
</template>

<script>
export default {
  name: 'Step2Page',
  data() {
    return {
      userId: '',
      userPw: '',
      isIdValid: false,
      isUserPwValid: false
    };
  },
  methods: {
    validateId() {
      const idRegex = /^[a-z0-9]{5,12}$/;
      this.isIdValid = idRegex.test(this.userId);
      this.$emit('update:valid', this.isIdValid && this.isUserPwValid);
    },
    validateUserPw() {
      const userPwRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;
      this.isUserPwValid = userPwRegex.test(this.userPw);
      this.$emit('update:user-pw-validity', this.isUserPwValid);
      this.$emit('update:valid', this.isIdValid && this.isUserPwValid);
    },
    goToNextStep() {
      this.$emit('next');
    }
  },
  watch: {
    userId() {
      this.validateId();
    },
    userPw() {
      this.validateUserPw();
    }
  }
};
</script>
