package resourceDemo2;

class Resource {
    private String name;
    private String sex;
    private boolean flag;
    public synchronized void set(String name,String sex){
        if (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.setName(name);
        this.setSex(sex);
        flag = true;
        this.notify();
    }
    public synchronized void out(){
        if(!flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(this.getName()+"+++"+this.getSex());
        flag = false;
        this.notify();
    }




    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Input implements Runnable {
    Resource resource;
    private boolean flag;

    Input(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {

                if (flag) {
                    resource.set("MIKE","MALE");
                } else {
                    resource.set("LILY","FEMALE");
                }
                flag = !flag;
            }
        }
    }
}

class Output implements Runnable {
    Resource resource;

    Output(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
              resource.out();

        }
    }
}

public class ResourceDemo2 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Input input = new Input(resource);
        Output output = new Output(resource);
        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);
        t1.start();
        t2.start();
    }
}
