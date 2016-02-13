
metadata {
	definition (name: "LED Shield", author: "jkress") {
/*    		capability "Switch"
            capability "Switch Level"
            capability "Refresh"
        	command "whiteLight"
            command "setNightLightColor"
        	attribute "whiteLight","string"
	}*/
/*
	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "on", label: '${name}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
			state "off", label: '${name}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
		}
		standardTile("greeting", "device.greeting", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'hello', action: "hello", icon: "st.switches.switch.off", backgroundColor: "#ccccff"
		}     
		valueTile("message", "device.greeting", inactiveLabel: false) {
			state "greeting", label:'${currentValue}', unit:""
		}
        
        controlTile("levelSliderControl", "device.level", "slider", height: 1,
            width: 2, inactiveLabel: false, range:"(0..100)") {
			state "level", action:"switch level.setLevel"
		}
        
		main "switch"
		details(["switch","greeting","message","levelSliderControl"])
	}
  */  
/*    tiles(scale: 2) {
		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "on", label:'${name}', action:"switch.off", icon:"st.switches.switch.on", backgroundColor:"#79b821"
				attributeState "off", label:'${name}', action:"switch.on", icon:"st.switches.switch.off", backgroundColor:"#ffffff"
			}
			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel"
			}
		}
		
		standardTile("refresh", "device.power", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:'', action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		
        
        standardTile("whiteLight", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'White Light', action: "whiteLight", icon: "st.switches.switch.off", backgroundColor: "#ccccff"
		}
        
        // NightLight Color Selector
        controlTile("nightlightColor", "device.nightlightRGB", "color", height: 3, width: 3, inactiveLabel: false) {
		    state "nightLightColor", label:"Night Light Color", action:"setNightLightColor"
        }
        
		main "switch"
		details(["switch","refresh","whiteLight", "nightlightColor"])
	}
*/

    capability "Actuator"
    capability "Configuration"
    capability "Refresh"
	capability "Sensor"
    capability "Switch"
	capability "Switch Level"
	capability "Color Control"  
    attribute "info","string"
    
    command "whiteLight"
    attribute "whiteLight","string"
    
    command "redAlert"
    attribute "redAlert","string"
    
    command "blueAlert"
    attribute "blueAlert","string"
    
    command "red"
    attribute "red","string"
    
    command "green"
    attribute "green","string"
    
    command "blue"
    attribute "blue","string"
    
    
    command "colorParty"
    attribute "colorParty","string"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles (scale: 2){
		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "on", label:'${name}', action:"switch.off", icon:"st.lights.philips.hue-single", backgroundColor:"#79b821"
				attributeState "off", label:'${name}', action:"switch.on", icon:"st.lights.philips.hue-single", backgroundColor:"#ffffff" 
			}
			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel"
			}
			tileAttribute ("device.color", key: "COLOR_CONTROL") {
				attributeState "color", action:"setColor"
			}
		}
		standardTile("refresh", "device.switch", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}		
        
        standardTile("whiteLight", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'White Light', action: "whiteLight", icon: "st.lights.philips.hue-single", backgroundColor: "#ccccff"
		}
        
        standardTile("redAlert", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Red Alert', action: "redAlert", icon: "st.Lighting.light11", backgroundColor: "#FF0000"
		}
        
        standardTile("blueAlert", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Blue Alert', action: "blueAlert", icon: "st.Lighting.light11", backgroundColor: "#0000FF"
		}
        
        standardTile("red", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Red', action: "red", icon: "st.lights.philips.hue-single", backgroundColor: "#FF0000"
		}
        
        standardTile("green", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Green', action: "green", icon: "st.lights.philips.hue-single", backgroundColor: "#00FF00"
		}
        
        standardTile("blue", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Blue', action: "blue", icon: "st.lights.philips.hue-single", backgroundColor: "#0000FF"
		}
        
        standardTile("colorParty", "device.greeting", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
			state "default", label: 'Party', action: "colorParty", icon: "st.Food & Dining.dining6", backgroundColor: "#00FFFF"
		}
        
		main(["switch"])
		details(["switch", "whiteLight", "redAlert", "blueAlert", "red", "green", "blue", "colorParty", "refresh"])
	}
}

// Commands to device
def on() {
	log.debug "on() command received"
    zigbee.smartShield(text: "on").format()
}

def off() {
	log.debug "off() command received"
	zigbee.smartShield(text: "off").format()
}

def hello() {
	log.debug "Hello World!"
	zigbee.smartShield(text: "hello").format()
}

def setLevel(value) {
	log.debug "setLevel($value)"
	zigbee.smartShield(text: "setLevel: $value").format()
}

def whiteLight() {
	log.debug "setWhiteLight() Command Received"
	zigbee.smartShield(text: "whiteLight").format()
}

def redAlert() {
	log.debug "redAlert() Command Received"
	zigbee.smartShield(text: "redAlert").format()
}

def blueAlert() {
	log.debug "blueAlert() Command Received"
	zigbee.smartShield(text: "blueAlert").format()
}

def red() {
	log.debug "red() Command Received"
	zigbee.smartShield(text: "red").format()
}

def green() {
	log.debug "green() Command Received"
	zigbee.smartShield(text: "green").format()
}

def blue() {
	log.debug "blue() Command Received"
	zigbee.smartShield(text: "blue").format()
}

def colorParty() {
	log.debug "colorParty() Command Received"
	zigbee.smartShield(text: "colorParty").format()
}

def setColor(value) {
	log.trace"setColor = ${value}"    
    def cx = value.hex    
    cx = cx.substring(1, cx.length())												// Remove # from front of hex value.hex string
    zigbee.smartShield(text: "rgbMix: $value.red $value.green $value.blue").format()
    //def cmds = []
    //cmds << "st wattr 0x${device.deviceNetworkId} 0x38 0x0008 0x400 0x23 {${cx}}"			// Send new RGB Color value write attribute 0x0400
    //cmds        
}

// Parse incoming device messages to generate events
def parse(String description) {
	log.debug "parse called with --> $description"
	Map map = [:]
	if (description?.startsWith('catchall:')) {
		map = parseCatchAllMessage(description)
	}
    else if (description?.startsWith('on/off')) {
    	map = parseOnOff(description)
    }
	else if (description?.startsWith('read attr -')) {
		map = parseReportAttributeMessage(description)
	}  
    else {
    	log.debug "No parse method for: $description"
    }
    
    if (map.value == "Device Boot"){
    	def result = []
    	List cmds = bootResponse()
    	log.trace "Sending current state to device ${cmds}"
        result = cmds?.collect { new physicalgraph.device.HubAction(it) }  
        return result 
    }else{
    	log.trace map
		return map ? createEvent(map) : null
    }
}

private Map parseReportAttributeMessage(String description) {
	log.debug "Map parseReportAttributeMessage called with --> $description"
    Map resultMap = [:]
    def descMap = parseDescriptionAsMap(description)
    //log.debug descMap
   
    if (descMap.cluster == "0008" && descMap.attrId == "0000") { 
        resultMap.name = "level"
        resultMap.value = (Integer.parseInt(descMap.value, 16))      
        resultMap.displayed = true  
        def v =(int)100 / (255/resultMap.value)
        if (v < 1){
        	resultMap.value = 1
        }else{
        	resultMap.value = v
        }
    }
    else if (descMap.cluster == "0008" && descMap.attrId == "0400") { 
        def cx = descMap.value
        cx = cx.substring(2, cx.length())												// Remove two 0 from front of string    
        resultMap.name = "color"        
        resultMap.value = "#${cx}"
        resultMap.displayed = true  
        setColorMapFromHexRGB(cx)														// Set Hue and Sat based on RGB Hex string
    }    
    
    else {
    	log.debug "Attribute match not found for --> $descMap"
    }
    return resultMap
}

private Map parseOnOff(String description) {
	log.debug "Map parseOnOff called with --> $description"
    Map resultMap = [:]    
    
    if(description?.endsWith("0")) {
        resultMap.name = "switch"
        resultMap.value = "off"
        resultMap.displayed = true
    }    
    else if(description?.endsWith("1")) {
        resultMap.name = "switch"
        resultMap.value = "on"
        resultMap.displayed = true
    }  
    else if(description?.endsWith("2")) { 
        resultMap.name = "info"
        resultMap.value = "Device Boot"
        resultMap.displayed = true    
    }      
    
    else {
    	log.debug "On/Off match not found for --> $description"
    }    
    return resultMap
}

private Map parseCatchAllMessage(String description) {
	log.debug "Map parseCatchAllMessage called with --> $description"
    Map resultMap = [:]    
    def cluster = zigbee.parse(description)
    log.debug cluster
    
    if (cluster.text == "on") {
    	//log.trace "On Off Cluster report = $cluster.data"
		// Switch is on attribute report       
        resultMap.name = "switch"
        resultMap.value = "on"   
        resultMap.displayed = true
    }
    
    if (cluster.text == "off") {
    	//log.trace "On Off Cluster report = $cluster.data"        
		// Switch is off attribute report   
        resultMap.name = "switch"
        resultMap.value = "off" 
        resultMap.displayed = true
    }
    
    if (cluster.text == "levelAck") {       
		// Level has been set  
        resultMap.name = "info"
        resultMap.value = "set level cmd ack"         
        resultMap.displayed = false  
    }
    
    else if (cluster.clusterId == 0x0006 && cluster.command == 0x0B) {			// command 0x0B = default response to command sent
    	//log.trace "On Off Cluster default response = $cluster.data"
        switch(cluster.data) {
        
        case "[0, 0]":															// Switch acknowledged off command   
        resultMap.name = "switch"
        resultMap.value = "off" 
        resultMap.displayed = false
        break     
        
        case "[1, 0]":															// Switch acknowledged on command        
        resultMap.name = "switch"
        resultMap.value = "on"        
        resultMap.displayed = false
        break                 
        }
    } 
    else if (cluster.clusterId == 0x0008 && cluster.command == 0x0B) {			// command 0x0B = default response to command sent
    	//log.trace "level Cluster default response = $cluster.data"  
        switch(cluster.data) {
        
        case "[0, 0]":															// Level command acknowledged  
        resultMap.name = "info"
        resultMap.value = "set level cmd ack"         
        resultMap.displayed = false        
        break                  
        }
   } 
    else if (cluster.clusterId == 0x0008 && cluster.command == 0x04) {			// command 0x04 = write attribuite cmd response
    	//log.trace "level Cluster default response = $cluster.data"  
        switch(cluster.data) {
        
        case "[0, 4, 0]":													  	// setColor command acknowledged  
        resultMap.name = "info"
        resultMap.value = "write color attribute ack"        
        resultMap.displayed = false        
        break             
        }
   }    
    else {
    	log.debug "CatchAll match not found for --> $description"
        log.debug "cluster.data = $cluster"
    }        
    
    return resultMap
}

// Commands
def bootResponse() {
	log.debug "Creating boot response"
    def swtch = device.currentState("switch")?.value												// Get the current on off value
    if (swtch == "on"){
        swtch = "1"								
    }else{
        swtch = "0"							
    }    
    def lvl = device.currentState("level")?.value as int											// Get the current brightness level
    lvl=(int)lvl * 2.56																				// Scale value basee on 1 to 256 for level
    def level = hexString(Math.round(lvl))     														
    def cx = device.currentState("color")?.value													// Get the current color value
	cx = cx.substring(1, cx.length())																// Remove # from front of hex value.hex string     
	[
       	"st cmd 0x${device.deviceNetworkId} 1 6 ${swtch} {}", "delay 200",							// Set On or Off
        "st cmd 0x${device.deviceNetworkId} 1 8 0 {${level} 0000}", "delay 200",
		"st wattr 0x${device.deviceNetworkId} 0x38 0x0008 0x400 0x23 {${cx}}", "delay 200"			// Send new RGB Color value write attribute 0x0400        
	]
}

/*
def on() {
	log.info "on cmd sent"
	"st cmd 0x${device.deviceNetworkId} 1 6 1 {}"
}

def off() {
	log.info "off cmd sent"
	"st cmd 0x${device.deviceNetworkId} 1 6 0 {}"
}

def setLevel(value) {
    if (value < 1){
        value = 1
    }else if (value > 99){
        value = 99
    }
    sendEvent(name: "level", value: value, displayed: false)    
    def cLevel=(int)value * 2.56													// Scale value basee on 1 to 256 for level
    log.info "Level ${value}% sacle = ${cLevel} sent"
	def cmds = []
    def level = hexString(Math.round(cLevel))
	cmds << "st cmd 0x${device.deviceNetworkId} 1 8 0 {${level} 0000}"
	cmds
}
*/



def refresh() {
	log.info "read attributes request sent"
    def cmd = []
    cmd << "st rattr 0x${device.deviceNetworkId} 0x38 0x0006 0x0000"     					// Read On / Off attribute
    cmd << "delay 500"
    cmd << "st rattr 0x${device.deviceNetworkId} 0x38 0x0008 0x0000"						// Read Level attribute 
    cmd << "delay 500"
    cmd << "st rattr 0x${device.deviceNetworkId} 0x38 0x0008 0x0400"    					// Read Custom attribute for RGB color value
    return cmd
}

def configure() {
    log.debug "Binding SEP 0x38 DEP 0x01 Cluster 0x0006 ON/Off cluster to hub"  
    log.debug "Binding SEP 0x38 DEP 0x01 Cluster 0x0008 Level cluster to hub"      
    
    def cmd = []
    cmd << "zdo bind 0x${device.deviceNetworkId} 0x38 0x01 0x0006 {${device.zigbeeId}} {}"	// Bind to end point 0x38 and the On/Off Cluster
    cmd << "delay 150"
    cmd << "zdo bind 0x${device.deviceNetworkId} 0x38 0x01 0x0008 {${device.zigbeeId}} {}"   // Bind to end point 0x38 and the Level Cluster
    cmd << "delay 1500"       
    
    return cmd + refresh() // send refresh cmds as part of config
}

// Utils

def setColorMapFromHexRGB(HexRGB) {
    //log.info "setColrMapFromHexRGB called with ${HexRGB}"    
    def r = Integer.parseInt(HexRGB.substring(0, HexRGB.length()-4), 16)
    def g = Integer.parseInt(HexRGB.substring(2, HexRGB.length()-2), 16)
    def b = Integer.parseInt(HexRGB.substring(4, HexRGB.length()), 16)
	def cCal = rgbToHSV(r, g, b)
	sendEvent(name: "hue", value: cCal.hue)
	sendEvent(name: "saturation", value: cCal.saturation)        
}

def parseDescriptionAsMap(description) {
    (description - "read attr - ").split(",").inject([:]) { map, param ->
        def nameAndValue = param.split(":")
        map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
    }
}

def rgbToHSV(red, green, blue) {
	float r = red / 255f
	float g = green / 255f
	float b = blue / 255f
	float max = [r, g, b].max()
	float delta = max - [r, g, b].min()
	def hue = 13
	def saturation = 0
	if (max && delta) {
		saturation = 100 * delta / max
		if (r == max) {
			hue = ((g - b) / delta) * 100 / 6
		} else if (g == max) {
			hue = (2 + (b - r) / delta) * 100 / 6
		} else {
			hue = (4 + (r - g) / delta) * 100 / 6
		}
	}
	[hue: hue, saturation: saturation, value: max * 100]
}

def huesatToRGB(float hue, float sat) {
	while(hue >= 100) hue -= 100
	int h = (int)(hue / 100 * 6)
	float f = hue / 100 * 6 - h
	int p = Math.round(255 * (1 - (sat / 100)))
	int q = Math.round(255 * (1 - (sat / 100) * f))
	int t = Math.round(255 * (1 - (sat / 100) * (1 - f)))
	switch (h) {
		case 0: return [255, t, p]
		case 1: return [q, 255, p]
		case 2: return [p, 255, t]
		case 3: return [p, q, 255]
		case 4: return [t, p, 255]
		case 5: return [255, p, q]
	}
}