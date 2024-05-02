// 팝업창 표시 함수
function openPopup(popupClass) {
    var popup = document.getElementsByClassName(popupClass)[0];
    popup.style.display = "block";
  }
  
  // 팝업창 닫기 함수
  function closePopup(popupClass) {
    var popup = document.getElementsByClassName(popupClass)[0];
    popup.style.display = "none";
  }
  
  // 방 만들기 버튼 클릭 시 팝업창 열기
  document.querySelector(".create-room-button").addEventListener("click", function() {
    openPopup("popup");
  });
  
  // 초대코드 버튼 클릭 시 팝업창 열기
  document.querySelector(".invite-code-button").addEventListener("click", function() {
    openPopup("invite-popup");
  });
  
  // 닫기 버튼 클릭 시 팝업창 닫기
  document.querySelectorAll(".close-button").forEach(function(closeButton) {
    closeButton.addEventListener("click", function() {
      closePopup(this.closest(".popup").classList[0]);
    });
  });
  
  // 문서 로드 시 팝업창 숨기기
  window.onload = function() {
    document.querySelectorAll(".popup").forEach(function(popup) {
      popup.style.display = "none";
    });
  };
  
  // 팀 생성 버튼 클릭 시 코드 생성 및 팝업창 열기
  document.querySelector(".create-room-button").addEventListener("click", function() {
    var roomName = document.getElementById("room-name").value;
    if (roomName.trim() !== "") {
      var generatedCode = generateRandomCode();
      document.getElementById("generated-code").textContent = generatedCode;
      openPopup("code-popup");
    }
  });
  
  // 랜덤 코드 생성 함수
  function generateRandomCode() {
    var characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var codeLength = 8;
    var code = "";
    for (var i = 0; i < codeLength; i++) {
      code += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return code;
  }
  
  // 코드 복사 함수
  function copyCode() {
    var generatedCode = document.getElementById("generated-code").textContent;
    navigator.clipboard.writeText(generatedCode)
      .then(function() {
        console.log("Code copied to clipboard: " + generatedCode);
      })
      .catch(function(error) {
        console.error("Failed to copy code to clipboard: ", error);
      });
    closePopup("code-popup");
  }
  
  function openPopup(popupId) {
      var popup = document.getElementById(popupId);
      popup.style.display = "block";
    }
    
    // 팝업창 닫기 함수
    function closePopup(popupId) {
      var popup = document.getElementById(popupId);
      popup.style.display = "none";
    }
    
    // 방 만들기 버튼 클릭 시 팝업창 열기
    document.querySelector(".create-room-button").addEventListener("click", function() {
      openPopup("popup");
    });
    
    // 초대코드 버튼 클릭 시 팝업창 열기
    document.querySelector(".invite-code-button").addEventListener("click", function() {
      openPopup("invite-popup");
    });
    
    // 닫기 버튼 클릭 시 팝업창 닫기
    document.querySelectorAll(".close-button").forEach(function(closeButton) {
      closeButton.addEventListener("click", function() {
        closePopup(this.closest(".popup").id);
      });
    });
    
    // 문서 로드 시 팝업창 숨기기
    window.onload = function() {
      document.querySelectorAll(".popup").forEach(function(popup) {
        popup.style.display = "none";
      });
    };
  
  