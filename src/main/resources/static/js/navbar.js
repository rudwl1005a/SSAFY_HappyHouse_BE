function navBar(){
	document.querySelector("#NavbtnRegister").onclick = function(){
		window.location.href="/register";
	}
	
	document.querySelector("#NavbtnApart").onclick = function(){
		window.location.href="/aparts";
	}

	
	if(sessionStorage.getItem("userId") != null){
		let btnLogout = `<a class="nav-link" id="NavbtnLogout" style="cursor: pointer">로그아웃</a>`;
		let btnUserinfo = `<a class="nav-link" id="NavbtnUserInfo" style="cursor: pointer">회원 정보</a>`;
		
		document.querySelector("#logout").innerHTML = btnLogout;
		document.querySelector("#userinfo").innerHTML = btnUserinfo;
		
		makeLogout();
		makeUserinfo();
		
	} else {
		let btn = `<a class="nav-link" id="NavbtnLogin" style="cursor: pointer">로그인</a>`;
		
		document.querySelector("#login").innerHTML = btn;
		
		makeLogin();
	}
}

function makeLogin(){
		document.querySelector("#NavbtnLogin").onclick = function(){
			window.location.href="/login";
		}
	}
		
	function makeLogout(){
		document.querySelector("#NavbtnLogout").onclick = function(){
			
			sessionStorage.removeItem("userId");	
			sessionStorage.removeItem("password");	
			sessionStorage.removeItem("name");
			sessionStorage.removeItem("authority");	
			
			window.location.href="/logout";
		}
	}
	
	function makeUserinfo(){
		document.querySelector("#NavbtnUserInfo").onclick = function(){
			window.location.href="/userinfo";
		}
	}