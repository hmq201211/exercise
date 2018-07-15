package resourceDemo1;

class Resource {
    private String name;
    private String sex;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
                if (resource.isFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (flag) {
                    resource.setName("MIKE");
                    resource.setSex("MALE");
                } else {
                    resource.setName("LILY");
                    resource.setSex("FEMALE");
                }
                resource.setFlag(true);
                resource.notify();
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

            synchronized (resource) {
                if (!resource.isFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(resource.getName() + resource.getSex());
                resource.setFlag(false);
                resource.notify();
            }
        }
    }
}

public class ResourceDemo1 {
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
