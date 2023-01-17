#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

import json;
import sys;
import string;

if len(sys.argv)!=2:
	print("Usage: python hack/list-swagger-objects.py <swagger-spec-location>")
	sys.exit(1)

swagger_spec_location=sys.argv[1]

with open(swagger_spec_location, 'r') as source:
	for model in json.load(source)["models"]:
		print(string.lower(model))