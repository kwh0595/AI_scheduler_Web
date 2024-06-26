
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
};

function change_btn(gender){
  var btns = document.querySelectorAll(".genders")
  btns.forEach(function(btn, i) {
    if(gender.currentTarget == btn){
      btn.classList.add("active");
    }
    else{
      btn.classList.remove("active");
    }
  });
  console.log(gender.currentTarget);
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
function updateBirthDate() {
  var year = document.getElementById("birth-year").value;
  var month = document.getElementById("birth-month").value;
  var day = document.getElementById("birth-day").value;
  document.getElementById("completeBirthDate").value = year + '-' + month + '-' + day;
}

document.getElementById("birth-year").addEventListener("change", updateBirthDate);
document.getElementById("birth-month").addEventListener("change", updateBirthDate);
document.getElementById("birth-day").addEventListener("change", updateBirthDate);
document.addEventListener('DOMContentLoaded', function() {
  const yearSelect = document.getElementById('birth-year');
  const monthSelect = document.getElementById('birth-month');
  const daySelect = document.getElementById('birth-day');
  const completeBirthDateInput = document.getElementById('completeBirthDate');

  function updateCompleteBirthDate() {
    const year = yearSelect.value;
    const month = monthSelect.value.padStart(2, '0'); // 한자리 숫자 앞에 0 붙이기
    const day = daySelect.value.padStart(2, '0'); // 한자리 숫자 앞에 0 붙이기
    if (year && month && day) {
      completeBirthDateInput.value = `${year}-${month}-${day}`;
    } else {
      completeBirthDateInput.value = ''; // 모든 필드가 선택되지 않았다면 입력값을 비웁니다.
    }
  }

  // 각 셀렉트 박스에 대해 change 이벤트 리스너 등록
  yearSelect.addEventListener('change', updateCompleteBirthDate);
  monthSelect.addEventListener('change', updateCompleteBirthDate);
  daySelect.addEventListener('change', updateCompleteBirthDate);

  // 초기화를 위해 함수를 한 번 호출
  updateCompleteBirthDate();
});
/**
 window.onload = function(){
  var hw = document.getElementById('hw');
  hw.addEventListener('click', function(){
    alert('Hello world');
  })
}
 */

function Click(){
  var agree_data;
  if(document.getElementById("agree").checked){
    agree_data="동의";
  }
  else if(document.getElementById("disagree").checked){
    agree_data="비동의";
  }
  else{
    alert("동의 버튼을 눌러주세요.");
  }

  if(agree_data.length!=0){
    location.replace("search_list.php?id="+agree_data);
  }
}

function Click2(){
  var agree_data2;
  if(document.getElementById("agree2").checked){
    agree_data2="동의";
  }
  else if(document.getElementById("disagree2").checked){
    agree_data2="비동의";
  }
  else{
    alert("동의 버튼을 눌러주세요.");
  }
  if(agree_data2.length!=0){
    location.replace("search_list.php?id="+agree_data2);
  }
}