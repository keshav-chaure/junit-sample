package com.kc.dto;

public class FileBean implements Comparable {
    long fileId;
    String fileName;
    int partNo;
    String resourceId;

    public FileBean(long fileId, String fileName, int partNo, String resourceId) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.partNo = partNo;
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileBean fileBean = (FileBean) o;

        if (fileId != fileBean.fileId) return false;
        if (partNo != fileBean.partNo) return false;
        if (fileName != null ? !fileName.equals(fileBean.fileName) : fileBean.fileName != null) return false;
        return resourceId != null ? resourceId.equals(fileBean.resourceId) : fileBean.resourceId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (fileId ^ (fileId >>> 32));
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + partNo;
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        return result;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getPartNo() {
        return partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "fileName='" + fileName + '\'' +
                ", partNo=" + partNo +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }

    public int compareTo(Object o) {
        int f=((FileBean)o).getPartNo();
        return this.partNo-f;
    }


}
