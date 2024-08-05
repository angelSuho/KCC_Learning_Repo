// 예외처리
// try ~ catch
// throw: 인워적으로 예외 발생
// finally: 예외의 발생 유무와 상관없이 반드시 실행
function runner() {
  try {
    console.log('hello');
    throw new Error('문제 발생');
  } catch(e) {
    console.error('error catch');
  } finally {
    console.log('Done.');
  }
}

runner();