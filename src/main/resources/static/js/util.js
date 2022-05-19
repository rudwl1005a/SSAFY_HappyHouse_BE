function makePaginationHtml(listRowCount, pageLinkCount, currentPageIndex, totalListItemCount, htmlTargetId){
	
	var targetUI = document.querySelector("#" + htmlTargetId);
	
	var pageCount = Math.ceil(totalListItemCount/listRowCount);

	var startPageIndex = 0;
	if( (currentPageIndex % pageLinkCount) == 0 ){ //10, 20...맨마지막
		startPageIndex = ((currentPageIndex / pageLinkCount)-1)*pageLinkCount + 1
	}else{
		startPageIndex = Math.floor(currentPageIndex / pageLinkCount)*pageLinkCount + 1
	}
	
	var endPageIndex = 0;
	if( (currentPageIndex % pageLinkCount) == 0 ){ //10, 20...맨마지막
		endPageIndex = ((currentPageIndex / pageLinkCount)-1)*pageLinkCount + pageLinkCount
	}else{
		endPageIndex = Math.floor(currentPageIndex / pageLinkCount)*pageLinkCount + pageLinkCount;
	}

	var prev;
	if( currentPageIndex <= pageLinkCount ){
		prev = false;
	}else{
		prev = true;
	}

	var next;
	if(endPageIndex > pageCount){
		endPageIndex = pageCount
		next = false;
	}else{
		next = true;
	}
	
	var paginationHtml =
		`<ul class="pagination pagination justify-content-center">`;
	if(prev){
		paginationHtml += 
			`<li class="page-item">
			 <a class="page-link" href="javascript:movePage( ${(startPageIndex - 1)} )" aria-label="Previous">
			 <span aria-hidden="true">&laquo;</span>
			 </a>
			 </li>`;
	}
	
	for(var i=startPageIndex; i<=endPageIndex; i++){
//		console.log('*** ' + i);
//		console.log(currentPageIndex);
		
		if( i == currentPageIndex ){
			paginationHtml += 
				`<li class="page-item active"><a class="page-link" href="javascript:movePage(${i})">${i}</a></li>`;			
		}else{
			paginationHtml += 
				`<li class="page-item"><a class="page-link" href="javascript:movePage(${i})">${i}</a></li>`;					
		}
	}
	
	if(next){
		paginationHtml += 
			`<li class="page-item">
			 <a class="page-link" href="javascript:movePage( ${(endPageIndex + 1)} )" aria-label="Next">
			 <span aria-hidden="true">&raquo;</span>
			 </a>
			 </li>`;
	}

	paginationHtml += `</ul>`;
	
	targetUI.innerHTML = paginationHtml;
	
}

function makeDateStr(year, month, day, type){
	//2010.05.05
	if( type == '.' ){
		return year + '.' + ( (month < 10) ? '0' + month : month ) + '.' + ( (day < 10) ? '0' + day : day );
	}
}

function makeTimeStr(hour, minute, second, type){
	//07:25:33
	if( type == ':' ){
		return hour + ':' + ( (minute < 10) ? '0' + minute : minute ) + ':' + ( (second < 10) ? '0' + second : second );
	}
}














