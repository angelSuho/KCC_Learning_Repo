console.log(add(10, 20));
console.log(add2(10, 20));

// 선언적 함수
function add(a, b) {
  let sum = a + b;
  return sum;
}
console.log(add(10, 20));

// 익명 함수 -> 일급 객체
let add2 = function(a, b) {
  let sum = a + b;
  return sum;
}
console.log(add2(10, 20));
// 함수의 메모리 주소로 초기화
let plus = add2;
// 함수의 결과로 초기화
let plus2 = add2();

console.log(plus(100, 200));
console.log(plus2); // 파라미터를 입력하지 않았었기 때문에 NaN

console.log(plus(10,200));

// 함수의 파라미터에 함수를 전달할 수 있다. (callback 함수)
let foo = function(func) {
  if (typeof func === 'function') {
    func();
  }
}

foo(function() {
  console.log('파라미터에 함수를 전달하는 예제');
});

// 함수가 함수를 리턴할 수 있다.
// 함수를 리턴하는 예제와 함께 리턴된 함수를 호출해보자.
function goo() {
  return function() {
    console.log('return되는 함수 입니다!');
  }
};

const doo = goo();
doo();

// 함수의 파라미터에 (plus or minus) 호출
// plus -> plus 기능을 하는 함수를 리턴
// minus -> minus 기능을 하는 함수를 리턴
// return 받은 해당 함수를 호출해서 사용해 보자.

let operator = {
  plus: function(a, b) {
    return a + b;
  },
  minus: function(a, b) {
    return a - b;
  }
}

function isOperate(str) {
  // if (str == "plus") {
  //   return operator.plus;
  // } else if (str == "minus") {
  //   return operator.minus;
  // }
  return operator[str];
}

let op = isOperate("plus");
console.log(op(10, 20));
op = isOperate("minus");
console.log(op(10, 20));

// callback 함수: 함수의 파라미터에 전달되는 함수
function sortDesending(a, b) {
  // 내림차순
  return b - a;
  // 오름차순
  // return a - b;
}

// 한자리 수일경우 sort()만으로도 정렬이 가능하나, 2자리 이상이면 직접 정렬기준을 정해야한다.
let arr = [54, 32, 4323, 434, 6234, 214];
console.log(arr.sort(sortDesending));

// 즉시실행함수: 함수 정의와 동시에 호출
(function(a, b) { 
  console.log(a + b)
})(10, 5);
