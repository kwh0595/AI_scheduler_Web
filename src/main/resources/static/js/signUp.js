
// 가입부분 체크

function signUpCheck(){

  let email = document.getElementById("email").value
  let name = document.getElementById("name").value
  let password = document.getElementById("password").value
  let passwordCheck = document.getElementById("passwordCheck").value
  let area = document.getElementById("area").value
  let gender_man = document.getElementById("gender_man").checked
  let gender_woman = document.getElementById("gender_woman").checked
  let check = true;

  // 이메일확인
  if(email.includes('@')){
    let emailId = email.split('@')[0]
    let emailServer = email.split('@')[1]
    if(emailId === "" || emailServer === ""){
      document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
      check = false
    }
    else{
      document.getElementById("emailError").innerHTML=""
    }
  }else{
    document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
    check = false
  }


  // 이름확인
  if(name===""){
    document.getElementById("nameError").innerHTML="이름이 올바르지 않습니다."
    check = false
  }else{
    document.getElementById("nameError").innerHTML=""
  }

  // 성별체크확인
  if(!gender_man && !gender_woman){
    document.getElementById("genderError").innerHTML="성별을 선택해주세요."
    check = false
  }else{
    document.getElementById("genderError").innerHTML=""
  }

  if(check){
    document.getElementById("emailError").innerHTML=""
    document.getElementById("nameError").innerHTML=""
    document.getElementById("passwordError").innerHTML=""

    //비동기 처리이벤트
    setTimeout(function() {
      alert("가입이 완료되었습니다.")
    },0);
  }
}

function change_btn(e){
  var btns = document.querySelectorAll(".genders")
  btns.forEach(function(btn, i) {
    if(e.currentTarget == btn){
      btn.classList.add("active");
    }
    else{
      btn.classList.remove("active");
    }
  });
  console.log(e.currentTarget);
}

const birthYearEl = document.querySelector('#birth-year')
isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function() {
  if(!isYearOptionExisted) {
    isYearOptionExisted = true
    for(var i = 1950; i<=2024; i++){
      const YearOption = document.createElement('option')
      YearOption.setAttribute('value', i)
      YearOption.innerText = i
      this.appendChild(YearOption);
    }
  }
});

const birthMonthEl = document.querySelector('#birth-month')
isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function() {
  if(!isMonthOptionExisted) {
    isMonthOptionExisted = true
    for(var i = 1; i<=12; i++){
      const MonthOption = document.createElement('option')
      MonthOption.setAttribute('value', i)
      MonthOption.innerText = i
      this.appendChild(MonthOption);
    }
  }
});

const birthDayEl = document.querySelector('#birth-day')
isDayOptionExisted = false;
birthDayEl.addEventListener('focus', function() {
  if(!isDayOptionExisted) {
    isDayOptionExisted = true
    for(var i = 1; i<=31; i++){
      const DayOption = document.createElement('option')
      DayOption.setAttribute('value', i)
      DayOption.innerText = i
      this.appendChild(DayOption);
    }
  }
});
function updateBirthDateField() {
  const year = document.querySelector('#birth-year').value;
  const month = document.querySelector('#birth-month').value.padStart(2, '0'); // always 2 digits
  const day = document.querySelector('#birth-day').value.padStart(2, '0'); // always 2 digits
  if(year && month && day) {
    document.querySelector('#completeBirthDate').value = `${year}-${month}-${day}`;
  }
}

document.querySelector('#birth-year').addEventListener('change', updateBirthDateField);
document.querySelector('#birth-month').addEventListener('change', updateBirthDateField);
document.querySelector('#birth-day').addEventListener('change', updateBirthDateField);
function change_btn(gender) {
  document.getElementById('sex').innerText = gender; // 선택된 성별을 표시
  document.getElementById('userSex').value = gender; // 숨겨진 필드에 성별 값 설정
}
/**
 window.onload = function(){
  var hw = document.getElementById('hw');
  hw.addEventListener('click', function(){
    alert('Hello world');
  })
}
 */