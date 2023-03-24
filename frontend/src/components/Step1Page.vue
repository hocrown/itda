<template>
  <div>
    <h2>Step 1</h2>
    <div>
      <label for="codeInput">가족 코드</label>
      <input type="text" id="codeInput" v-model="code" :readonly="isCodeGenerated" />
      <button type="button" @click="generateCode" :disabled="isCodeGenerated">코드 생성</button>
    </div>
    <button type="button" @click="goToNextStep" :disabled="!isCodeValid">다음</button>
  </div>
</template>

<script>


export default {
  name: 'Step1Page',
  props: {
    familyCode: String,
    isCodeGenerated: Boolean
  },
  data() {
    return {
      code: this.familyCode,
      isCodeValid: !!this.familyCode
    };
  },
  methods: {
    generateCode() {
      const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
      let code = '';
      for (let i = 0; i < 6; i++) {
        code += characters.charAt(Math.floor(Math.random() * characters.length));
      }
      this.code = code;
      this.isCodeValid = true;
      this.$emit('update:code', code);
      this.$emit('update:valid', true);
    },
    goToNextStep() {
      this.$router.push({name:'Step2Page'});
    }
  }
};
</script>
