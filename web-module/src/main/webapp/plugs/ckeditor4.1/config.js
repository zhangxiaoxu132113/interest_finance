/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	
	config.filebrowserUploadUrl= "/article/uploadImg";
    config.filebrowserImageUploadUrl= "/article/uploadImg"; //要上传的Controller


	var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //config.filebrowserImageUploadUrl = projectName+'/system/userArticleFileUpload.do'; //固定路径
    //设置toolbar的样式
	config.toolbar = 'Full';
	//设置文本编辑启动额高度
	config.height = 500;

    //config.extraPlugins +=

    config.extraPlugins += (config.extraPlugins ? ',imageuploader' : 'imageuploader');

    config.toolbar_Full =
        [
            { name: 'document', items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
            { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
            { name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
            { name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton',
                'HiddenField' ] },
            '/',
            { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
            { name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv',
                '-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
            { name: 'links', items : [ 'Link','Unlink','Anchor' ] },
            { name: 'insert', items : [ 'imageuploader','Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },
            '/',
            { name: 'styles', items : [ 'Styles','Format','Font','FontSize','lineheight' ] },
            { name: 'colors', items : [ 'TextColor','BGColor' ] },
            { name: 'tools', items : [ 'Maximize', 'ShowBlocks','-','About' ] }
        ];


    config.font_names = 'Arial;Times New Roman;Verdana;宋体;微软雅黑';
};













		//设置文件的浏览路径 
		//editorObj.config.filebrowserBrowseUrl = ""; 
		//设置图片的浏览路径 
		//editorObj.config.filebrowserImageBrowseUrl = ""; 
		//设置flash文件浏览路径 
		//editorObj.config.filebrowserFlashBrowseUrl = ""; 
		//设置文件上传文件地址 
		//editorObj.config.filebrowserUploadUrl = ""; 
		//设置图片文件上传地址 
		//editorObj.config.filebrowserImageUploadUrl = "新地址"; 
		//设置flash文件上传地址 
		//editorObj.config.filebrowserFlashUploadUrl = ""; 




