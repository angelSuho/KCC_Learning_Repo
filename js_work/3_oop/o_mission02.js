/**
 * 1) Country 클래스는 나라 이름과 나라에 해당되는 아이돌 그룹정보를 
 *    리스트로 들고있다. (name 프로퍼티, idolGroups 프로퍼티)
 * 2) IdolGroup 클래스는 아이돌 그룹 이름과 멤버 정보를 리스트로 들고있다.
 *    (name 프로퍼티, members 프로퍼티)
 * 3) Idol 클래스는 아이돌 이름과 출생년도 정보를 들고있다.
 *    (name 프로퍼티, year 프로퍼티)
 * 4) MaleIdol 클래스는 Idol 클래스와 동일하게 
 *    name, year 프로퍼티가 존재한다
 *    추가로 sing() 함수를 실행하면 ${이름}이 노래를 합니다.
 *    라는 스트링을 반환해준다.
 * 5) FemaleIdol 클래스는 Idol 클래스와 동일하게
 *    name, year 프로퍼티가 존재한다.
 *    추가로 dance() 함수를 실행하면 ${이름}이 춤을 춥니다.
 *    라는 스트링을 반환해준다.
 * 
 * 아래 정보가 주어졌을때 위 구조로 데이터를 형성해보라.
 * map() 함수를 잘 활용하면 좋다.
 */

// 아이브는 한국 아이돌이고
// 아이브라는 이름의 걸그룹이다.
// 아이브는 여자 아이돌이다.
const iveMembers = [
  {
      name: '안유진',
      year: 2003,
  },
  {
      name: '가을',
      year: 2002,
  },
  {
      name: '레이',
      year: 2004,
  },
  {
      name: '장원영',
      year: 2004,
  },
  {
      name: '리즈',
      year: 2004,
  },
  {
      name: '이서',
      year: 2007,
  },
]

// BTS는 한국 아이돌이고
// 방탄소년단이라는 이름의 보이그룹이다.
// BTS는 남자 아이돌이다.
const btsMembers = [
  {
      name: '진',
      year: 1992,
  },
  {
      name: '슈가',
      year: 1993,
  },
  {
      name: '제이홉',
      year: 1994,
  },
  {
      name: 'RM',
      year: 1994,
  },
  {
      name: '지민',
      year: 1995,
  },
  {
      name: '뷔',
      year: 1995,
  },
  {
      name: '정국',
      year: 1997,
  },
]

// Country 클래스
class Country {
    name;
    idolGroups;
    
    constructor(name, idolGroups) {
        this.name = name;
        this.idolGroups = idolGroups;
    }
}

// IdolGroup 클래스
class IdolGroup {
    name;
    members;

    constructor(name, members) {
        this.name = name;
        this.members = members;
    }
}

// Idol 클래스
class Idol {
    name;
    year;

    constructor(name, year) {
        this.name = name;
        this.year = year;
    }
}

// Idol 클래스를 상속받는 MaleIdol 클래스
class MaleIdol extends Idol {
    constructor(name, year) {
        super(name, year);
    }

    sing() {
        return `${this.name}이(가) 노래를 합니다.`;
    }
}

// Idol 클래스를 상속받는 FemaleIdol 클래스
class FemaleIdol extends Idol {
    constructor(name, year) {
        super(name, year);
    }

    dance() {
        return `${this.name}이(가) 춤을 춥니다.`;
    }
}

// Country 객체 생성
// 1. 아이브 멤버 정보를 FemaleIdol 클래스로 변환 (new FemaleIdol())
// 2. 방탄소년단 멤버 정보를 MaleIdol 클래스로 변환 (new MaleIdol())
// 3. 각각의 아이돌 그룹에 멤버 정보를 할당 (IdolGroup 클래스)
// 4. Country 객체에 아이돌 그룹 정보를 할당 (Country 클래스)
const koreanIdol = new Country('대한민국', 
    [
        new IdolGroup('IVE', iveMembers
            .map(member => new FemaleIdol(member.name, member.year))),
        new IdolGroup('BTS', btsMembers
            .map(member => new MaleIdol(member.name, member.year)))
    ]
);

// Country 객체 데이터 구조 출력
console.log(koreanIdol);

// Country 객체 출력
// 1. Country 객체의 idolGroups 정보 출력
// 2. 아이돌 그룹의 멤버 정보 출력
for (const idolGroup of koreanIdol.idolGroups) {
    console.log(`${koreanIdol.name} 아이돌 그룹: ${idolGroup.name}`);
    for (const member of idolGroup.members) {
        console.log(`- ${member.name} (${member.year}년생)`);
        if (member instanceof FemaleIdol) {
            console.log(`${member.dance()}\n`);
        } else if (member instanceof MaleIdol) {
            console.log(`${member.sing()}\n`);
        }
    }
    console.log('---------------------');
}

// 과거 코드
// const iveMemberList = iveMembers
//     .map(member => new FemaleIdol(member.name, member.year));
// const btsMemberList = btsMembers
//     .map(member => new MaleIdol(member.name, member.year));
// const bts = new Country('한국',
//     new IdolGroup('방탄소년단', btsMembers
//         .map(member => new MaleIdol(member.name, member.year)))
// );
// const ive = new Country('한국',
//     new IdolGroup('아이브', iveMembers
//         .map(member => new FemaleIdol(member.name, member.year)))
// );
// const bts = new Country('한국',
//     new IdolGroup('방탄소년단', btsMembers
//         .map(member => new MaleIdol(member.name, member.year)))
// );
// for (const member of ive.idolGroups.members) {
//     console.log(member.dance());
// }
// console.log('---------------------');
// for (const member of bts.idolGroups.members) {
//     console.log(member.sing());
// }
// const idolGroups = [
//     new IdolGroup('아이브', iveMembers
//         .map(member => new FemaleIdol(member.name, member.year))),
//     new IdolGroup('방탄소년단', btsMembers
//         .map(member => new MaleIdol(member.name, member.year)))
// ];