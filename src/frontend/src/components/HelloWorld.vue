<template>
  <h1>{{ msg }}</h1>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    console.log('before fetch');
    fetch("/api/messages/hello")
    .then((res) => res.text())
    .then((data) => {
      console.log('data:', data);
      this.msg = data;
    });
  }
}
</script>