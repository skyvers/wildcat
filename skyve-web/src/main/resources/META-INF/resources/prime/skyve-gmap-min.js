SKYVE.BizMap=function(){var a={};var c=new Wkt.Wkt();var b=function(f,d){if(!f._refreshRequired){return}if(f._refreshing){return}f._refreshing=true;var e="";if(f.loading=="lazy"){c.fromObject(bounds.getNorthEast());e="&_ne="+c.write();c.fromObject(bounds.getSouthWest());e+="&_sw="+c.write()}$.get(f.url+e,function(g){try{SKYVE.GMap.scatter(f,g,d,true)}finally{f._refreshing=false}})};return{create:function(f){var e={zoom:1,center:new google.maps.LatLng(0,0),mapTypeId:google.maps.MapTypeId.ROADMAP};var k=a[f.elementId];if(k){if(k.webmap){e.zoom=k.webmap.getZoom();e.center=k.webmap.getCenter();e.mapTypeId=k.webmap.getMapTypeId()}if(k._intervalId){clearInterval(k._intervalId);k._intervalId=null}}else{k={_objects:{},_overlays:[],refreshTime:f.refreshTime,_refreshRequired:true,_refreshing:false,_intervalId:null,click:function(l,m){SKYVE.BizMap.click(this,l,m)},rerender:function(){b(this,false)},moduleName:f.moduleName,queryName:f.queryName,geometryBinding:f.geometryBinding,documentName:f.documentName,modelName:f.modelName};a[f.elementId]=k}var j=false;if(k.documentName){var g=k.moduleName+"_"+k.documentName+"_"+k.modelName;var i=sessionStorage.getItem(g);if(i){j=true;var h=JSON.parse(i);e.center=h.centre;e.zoom=h.zoom;sessionStorage.removeItem(g)}}else{var g=k.moduleName+"_"+k.queryName+"_"+k.geometryBinding;var i=sessionStorage.getItem(g);if(i){j=true;var h=JSON.parse(i);e.center=h.centre;e.zoom=h.zoom;sessionStorage.removeItem(g)}}k.infoWindow=new google.maps.InfoWindow({content:""});k.webmap=new google.maps.Map(SKYVE.PF.getByIdEndsWith(f.elementId)[0],e);if(f.showRefresh){SKYVE.GMap.refreshControls(k)}if(f.loading==="lazy"){google.maps.event.addListener(k.webmap,"zoom_changed",function(){if(!k._refreshing){b(k,false)}});google.maps.event.addListener(k.webmap,"dragend",function(){b(k,false)})}var d=SKYVE.Util.CONTEXT_URL+"map?";if(f.modelName){d+="_c="+f._c+"&_m="+f.modelName}else{if(f.queryName){d+="_mod="+f.moduleName+"&_q="+f.queryName+"&_geo="+f.geometryBinding}}k.url=d;b(k,(!j));if((k.refreshTime>0)&&k._refreshRequired){k._intervalId=setInterval(k.rerender.bind(k),k.refreshTime*1000)}return k},get:function(d){return a[d]},click:function(l,j,e){if(l.documentName){sessionStorage.setItem(l.moduleName+"_"+l.documentName+"_"+l.modelName,'{"centre":'+JSON.stringify(l.webmap.getCenter().toJSON())+',"zoom":'+l.webmap.getZoom()+"}")}else{sessionStorage.setItem(l.moduleName+"_"+l.queryName+"_"+l.geometryBinding,'{"centre":'+JSON.stringify(l.webmap.getCenter().toJSON())+',"zoom":'+l.webmap.getZoom()+"}")}var g=j.infoMarkup;g+='<br/><br/><input type="button" value="Zoom" onclick="window.location=\''+SKYVE.Util.CONTEXT_URL;g+="?m="+j.mod+"&d="+j.doc+"&i="+j.bizId+"'\"/>";if(j.getPosition){l.infoWindow.open(this.webmap,j);l.infoWindow.setContent(g)}else{if(j.getPath){var d=new google.maps.LatLngBounds();var o=j.getPath();for(var i=0,f=o.getLength();i<f;i++){d.extend(o.getAt(i))}var h=d.getNorthEast();var m=d.getSouthWest();l.infoWindow.setPosition(e.latLng);l.infoWindow.open(l.webmap);l.infoWindow.setContent(g)}}}}}();SKYVE.BizMapPicker=function(){var a={};var b=new Wkt.Wkt();return{create:function(e){var d={zoom:SKYVE.Util.mapZoom,center:SKYVE.GMap.centre(),mapTypeId:google.maps.MapTypeId.ROADMAP,mapTypeControlOptions:{style:google.maps.MapTypeControlStyle.DROPDOWN_MENU}};var f=a[e.elementId];if(f){if(f.webmap){d.zoom=f.webmap.getZoom();d.center=f.webmap.getCenter();d.mapTypeId=f.webmap.getMapTypeId()}}else{f={_objects:{},_overlays:[],setFieldValue:function(g){SKYVE.PF.setTextValue(c+"_value",g)}};a[e.elementId]=f}var c=SKYVE.PF.getByIdEndsWith(e.elementId).attr("id");f.webmap=new google.maps.Map(document.getElementById(c),d);if(!e.disabled){SKYVE.GMap.drawingTools(f);SKYVE.GMap.geoLocator(f)}SKYVE.GMap.clear(f);SKYVE.GMap.scatterValue(f,SKYVE.PF.getTextValue(c+"_value"))}}}();