package com.inter12.pinellia.common.framework;

public abstract class TemplateProcessor implements LProcessor {

    protected String name;

    public void handle(LDefaultContext context) {
        Object doWork = null;
        try {
            nameConfig();
            doWork = doWork(context);
        } catch (Exception e) {

            // default handle is ignore error !
            doExeption(e);
        }

        context.addResult(name, doWork);
    }

    /**
     * 异常处理的默认实现，子类可覆盖
     * 
     * @param e
     */
    public void doExeption(Exception e) {

    }

    /**
     * 配置各个子模块的结果集
     */
    protected abstract void nameConfig();

    protected abstract Object doWork(LDefaultContext context);

    public void setName(String name) {
        this.name = name;
    }

}
