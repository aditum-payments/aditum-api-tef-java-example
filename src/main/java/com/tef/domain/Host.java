package com.tef.domain;

public class Host {

    // Attributes

   private String applicationVersion = null;
   private String kernelType = null;
   private String kernelVersion = null;
   private String machineUniqueId = null;
   private String osType = null;
   private String osVersion = null;

   //Getters & Setters


    public String getApplicationVersion() {
        return this.applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getKernelType() {
        return this.kernelType;
    }

    public void setKernelType(String kernelType) {
        this.kernelType = kernelType;
    }

    public String getKernelVersion() {
        return this.kernelVersion;
    }

    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }

    public String getMachineUniqueId() {
        return this.machineUniqueId;
    }

    public void setMachineUniqueId(String machineUniqueId) {
        this.machineUniqueId = machineUniqueId;
    }

    public String getOsType() {
        return this.osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

}
