/**
 * 생성자 함수를 이용한 객체 생성 -> 다수의 객체 생성
 */
function Student(name, kor, eng, mat) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.mat = mat;
    this.getTotal = function () {
        return this.kor + this.eng + this.mat;
    }
    this.getAverage = function () {
        return this.getTotal() / 3;
    }
    this.toString = function () {
        return `${this.name}\t${this.kor}\t${this.eng}\t${this.mat}\t${this.getTotal()}\t${this.getAverage()}`;
    }
}
let students = [];
students.push(new Student('홍길동', 100, 90, 80));
students.push(new Student('김길동', 90, 80, 70));

for (let i in students) {
    console.log(students[i].toString());
}