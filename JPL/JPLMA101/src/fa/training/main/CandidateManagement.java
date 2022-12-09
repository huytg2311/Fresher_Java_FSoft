package fa.training.main;

import fa.training.services.CandidateService;

import java.io.IOException;

public class CandidateManagement {
    public static void main(String[] args) throws IOException {
        CandidateService candidateService = new CandidateService();
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    fresherService.writeFresher();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                fresherService.readFresher();
//            }
//        };
//
//        Thread thread3 = new Thread() {
//            @Override
//            public void run() {
//                fresherService.listFresher();
//            }
//        };
//
//        thread1.setPriority(1);
//        thread2.setPriority(2);
//        thread3.setPriority(3);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        fresherService.writeFresher();
        candidateService.readFresher();
//        fresherService.listFresher();
    }
}
