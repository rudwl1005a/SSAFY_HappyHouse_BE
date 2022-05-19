class NavBarClass extends HTMLElement {
  connectedCallback() {
    let newLabel = document.createElement('label')
    this.appendChild(newLabel)
    
    this.innerHTML =
		    `<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="/index">HappyHouse</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item" id="login"></li>
			        <li class="nav-item" id="logout"></li>
			        <li class="nav-item">
			          <a class="nav-link" id="NavbtnRegister" style="cursor: pointer">회원가입</a>
			        </li>
			        <li class="nav-item" id="userinfo"></li>
			        <li class="nav-item">
			          <a class="nav-link" id="NavbtnApart" style="cursor: pointer">아파트 검색</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>`
  }
}

//customElements.define('custom-navbar', NavBarClass);
