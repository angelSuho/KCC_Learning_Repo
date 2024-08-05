/**
 * 함수 클로저
 * -> 함수 호출 이후에도 함수의 실행 컨텍스트 영역을 유지하는 것
 */

function outerFunc() {
  var x = 10;
  var innerFunc = function() {
    console.log(x);
  };
  return innerFunc;
}
const inner = outerFunc();
inner();

// 데이터 캐싱
function cacheFunction(newNumb) {
  // 아주 오래 소요하는 작업
  var number = 10 * 10;
  return number * newNumb;
}

console.log(cacheFunction(10));
console.log(cacheFunction(20));

function cacheFunction2() {
  // 아주 오래 소요하는 작업
  var number = 10 * 10;

  return function(newNumb) {
    return number * newNumb;
  }
}

const runner = cacheFunction2();
console.log(runner(30));
console.log(runner(40));


var x = 10;
function cacheFunction3() {
  var x = 30;
  return function() {
    console.log(x);
  }
}

const runner2 = cacheFunction3();
runner2();

function outer(arg1, arg2) {
  var cacheSum = 5;
  function inner(innerArg) {
    cacheSum += arg1 + arg2 + innerArg;
    console.log(cacheSum);
  }
  return inner;
}

const result = outer(100, 200);
result(10);
result(20);
result(30);

// let inner2 = outer(100, 200);
// inner2(10);
outer(100, 200)(50);
