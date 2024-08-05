// 1. 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 함을 return하도록 solution함수를 완성해주세요.
// ex) console.log(solution(930211));
function solution1(n) {
    var answer = 0;
    var str = String(n);
    for (let i = 0; i < str.length; i++) {
        answer += parseInt(str[i]);
    }
    return answer;
}
console.log(solution1(930211));

// 2. 문자열 my_string이 매개변수로 주어질 때, my_string안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
// 힌트) isNaN()
// ex) console.log(solution("p2o4i8gj2"));
function solution2(n) {
  let answer = [];
  for (let i = 0; i < n.length; i++) {
    if (!isNaN(n[i])) {
      answer.push(n[i]);
    }
  }
  return answer.sort();
}
console.log(solution2("p2o4i8gj2"));

// 3. 년도인자만 받을 경우 -> "1234년"과 같은 문자열을 리턴
// 년도, 월 인자를 받을 경우 0> "1234년 5월" 과 같은 문자열을 리턴
// 년도, 월, 일 인자를 전부 받을 경우 -> "1234/5/6"과 같은 형식의 문자열을 리턴해주세요.
// ex) console.log(meetAt(2024, 7, 11));
function meetAt(y, m = null, d = null) {
  if (m == null && d == null) {
    return `${y}년`;
  } else if (m != null && d == null) {
    return `${y}년 ${m}월`;
  } else {
    return `${y}/${m}/${d}`;
  }
}
console.log(meetAt(2024));
console.log(meetAt(2024, 7));
console.log(meetAt(2024, 7, 11));