package g13c.cw2.zd5.library;

import java.time.LocalDate;
import java.time.Period;

abstract class BaseObject {

    private LocalDate createDate;

    public int getAge(){
        if(createDate == null)return 0;
        return Period.between(createDate, LocalDate.now()).getYears();
    }

    protected LocalDate getCreateDate(){
        return createDate;
    }

    protected void setCreateDate(LocalDate localDate){
        ArgumentValidator.checkArgIsNull(localDate);
        createDate = localDate;
    }
}
