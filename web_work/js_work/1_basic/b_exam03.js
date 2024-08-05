console.log(5 == 5);
// 값만 구분하기 때문에 true
console.log(5 == '5');
// 값의 타입을 구분하기 때문에 false
console.log(5 === '5');

console.log(0 == ''); // false (0, '' 은 둘다 false 임으로 true)
console.log(true == 1); // true (값이 있다면 true기 때문에 true)

// for ~ in VS for ~ of
const gilDong = {
  name: 'gilDong',
  year: 2000,
  company: 'kcc'
};

for (let key in gilDong) {
  console.log(key);
  console.log(gilDong[key]);
}

const kccMember = ['노승우', '김상학', '황철원', '송예림'];

for (let key in kccMember) {
  // console.log(key);
  console.log(`${key}: ${kccMember[key]}`);
}

for (let value of kccMember) {
  console.log(value);
}

// ||
console.log('Cat' || 'Dog');
let event = '';
event = event || '영화보기';
console.log(event);

if (event) {
  console.log("놀기");
} else {
  console.log("일하기");
}

