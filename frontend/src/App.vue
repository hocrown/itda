<template>
  <div>
    <router-view />
  </div>
</template>

<script>
export default {
  methods: {
    goToIndexPage() {
      this.$router.push({
        path: '<%=request.getContextPath()%>/index.jsp'
      })
    }
  }
}
</script>






