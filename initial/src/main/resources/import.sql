INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);
INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (1,'ironman','$2a$10$jXlure/BaO7K9WSQ8AMiOu3Ih3Am3kmmnVkWWHZEcQryZ8QPO3FgC','2019-11-15 22:14:54');
INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (2,'rabi','$2a$10$0tFJKcOV/Io6I3vWs9/Tju8OySoyMTpGAyO0zaAOCswMbpfma0BSK','2019-10-15 22:14:54');
